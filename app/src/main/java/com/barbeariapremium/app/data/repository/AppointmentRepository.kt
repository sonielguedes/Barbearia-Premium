package com.barbeariapremium.app.data.repository

import com.barbeariapremium.app.data.local.dao.AppointmentDao
import com.barbeariapremium.app.data.local.prefs.PreferenceManager
import com.barbeariapremium.app.data.model.Appointment
import com.barbeariapremium.app.data.model.Promotion
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import com.barbeariapremium.app.notifications.NotificationHelper
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppointmentRepository @Inject constructor(
    private val db: FirebaseFirestore,
    private val appointmentDao: AppointmentDao,
    private val preferenceManager: PreferenceManager,
    @ApplicationContext private val context: Context
) {
    private val appointmentsCollection = db.collection("appointments")

    suspend fun createAppointment(appointment: Appointment): Result<Boolean> {
        return try {
            val unitId = preferenceManager.getSelectedUnitId() ?: "1"
            val docRef = appointmentsCollection.document()
            val appointmentWithId = appointment.copy(
                id = docRef.id,
                unitId = unitId
            )
            docRef.set(appointmentWithId).await()
            appointmentDao.insertAppointment(appointmentWithId)
            
            // Enviar Notificação Local
            NotificationHelper.showNotification(
                context = context,
                title = "Agendamento Confirmado! ✂️",
                message = "Seu horário para ${appointmentWithId.serviceName} com ${appointmentWithId.barberName} foi reservado para ${appointmentWithId.date} às ${appointmentWithId.time}."
            )

            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun getUserAppointmentsFlow(userId: String): Flow<List<Appointment>> {
        return appointmentDao.getUserAppointments(userId)
    }

    fun getAllAppointmentsFlow(): Flow<List<Appointment>> {
        return appointmentDao.getAllAppointments()
    }

    suspend fun fetchAllAppointments() {
        try {
            val unitId = preferenceManager.getSelectedUnitId() ?: "1"
            val snapshot = appointmentsCollection
                .whereEqualTo("unitId", unitId)
                .get().await()
            val appointments = snapshot.toObjects(Appointment::class.java)
            appointmentDao.insertAppointments(appointments)
        } catch (e: Exception) {
            // Log error
        }
    }

    suspend fun fetchAndCacheUserAppointments(userId: String) {
        try {
            val snapshot = appointmentsCollection
                .whereEqualTo("userId", userId)
                .get()
                .await()
            val appointments = snapshot.toObjects(Appointment::class.java)
            appointmentDao.insertAppointments(appointments)
        } catch (e: Exception) {
            // Log error
        }
    }

    suspend fun getUserAppointments(userId: String): List<Appointment> {
        fetchAndCacheUserAppointments(userId)
        return appointmentDao.getUserAppointments(userId).first()
    }

    suspend fun getBarberAppointments(barberId: String, date: String): List<Appointment> {
        return try {
            val unitId = preferenceManager.getSelectedUnitId() ?: "1"
            val snapshot = appointmentsCollection
                .whereEqualTo("unitId", unitId)
                .whereEqualTo("barberId", barberId)
                .whereEqualTo("date", date)
                .get()
                .await()
            snapshot.toObjects(Appointment::class.java).filter { it.status != "CANCELLED" }
        } catch (e: Exception) {
            android.util.Log.e("AppointmentRepo", "Error getting barber appointments", e)
            emptyList()
        }
    }

    suspend fun updateAppointmentStatus(appointmentId: String, status: String): Result<Boolean> {
        return try {
            appointmentsCollection.document(appointmentId).update("status", status).await()
            
            // Lógica de Fidelidade: Se concluído, adiciona pontos e cashback
            if (status == "COMPLETED") {
                val snapshot = appointmentsCollection.document(appointmentId).get().await()
                val appointment = snapshot.toObject(Appointment::class.java)
                if (appointment != null) {
                    processLoyaltyForAppointment(appointment)
                    appointmentDao.insertAppointment(appointment.copy(status = "COMPLETED"))
                }
            } else {
                val snapshot = appointmentsCollection.document(appointmentId).get().await()
                snapshot.toObject(Appointment::class.java)?.let {
                    appointmentDao.insertAppointment(it)
                }
            }
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private suspend fun processLoyaltyForAppointment(appointment: Appointment) {
        try {
            val userRef = db.collection("users").document(appointment.userId)
            db.runTransaction { transaction ->
                val userSnapshot = transaction.get(userRef)
                val currentPoints = userSnapshot.getLong("loyaltyPoints") ?: 0L
                val currentCashback = userSnapshot.getDouble("cashbackAmount") ?: 0.0
                val userStatus = userSnapshot.getString("status") ?: "BRONZE"

                // Regras: 1 ponto por real + % de cashback baseado no status/plano
                val pointsToAdd = appointment.price.toInt()
                
                // Busca o percentual de cashback do usuário
                // Se for um plano assinado, o percentual vem do plano. 
                // Caso contrário, usa o padrão por tier.
                val cashbackPercent = when (userStatus.uppercase(java.util.Locale.ROOT)) {
                    "DIAMOND", "PLATINUM" -> 0.15
                    "GOLD" -> 0.10
                    "SILVER" -> 0.05
                    "BRONZE" -> 0.03
                    else -> 0.03
                }

                val cashbackToAdd = appointment.price * cashbackPercent

                val newPoints = currentPoints + pointsToAdd
                val newCashback = currentCashback + cashbackToAdd

                // Upgrade de Status automático
                val newStatus = when {
                    newPoints >= 5000 -> "PLATINUM"
                    newPoints >= 2000 -> "GOLD"
                    newPoints >= 500 -> "SILVER"
                    else -> "BRONZE"
                }

                transaction.update(userRef, "loyaltyPoints", newPoints)
                transaction.update(userRef, "cashbackAmount", newCashback)
                transaction.update(userRef, "status", newStatus)

                // Disparar Notificação de Upgrade se houver mudança
                if (newStatus != userStatus) {
                    NotificationHelper.showNotification(
                        context = context,
                        title = "NOVO STATUS: $newStatus! 🏆",
                        message = "Parabéns! Você subiu de nível. Aproveite agora seus benefícios e cashback de maior valor."
                    )
                }
            }.await()
        } catch (e: Exception) {
            // Log loyalty processing error
        }
    }

    suspend fun blockSchedule(barberId: String, barberName: String, date: String, time: String): Result<Boolean> {
        val block = Appointment(
            id = "",
            userId = "ADMIN_BLOCK",
            userName = "BLOQUEADO",
            serviceId = "BLOCK",
            serviceName = "Bloqueio de Agenda",
            barberId = barberId,
            barberName = barberName,
            date = date,
            time = time,
            status = "BLOCKED",
            price = 0.0
        )
        return createAppointment(block)
    }

    suspend fun getAllAppointments(): List<Appointment> {
        return try {
            val unitId = preferenceManager.getSelectedUnitId() ?: "1"
            val snapshot = appointmentsCollection
                .whereEqualTo("unitId", unitId)
                .get().await()
            snapshot.toObjects(Appointment::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }

    // --- Gestão de Promoções ---
    private val promotionsCollection = db.collection("promotions")

    fun getPromotionsFlow(): Flow<List<Promotion>> {
        // Para simplificar agora, retornamos do Firestore diretamente ou criamos um DAO
        // Por enquanto, vamos retornar uma lista estática convertida em Flow ou implementar o cache
        return kotlinx.coroutines.flow.flow {
            try {
                val snapshot = promotionsCollection.get().await()
                emit(snapshot.toObjects(Promotion::class.java))
            } catch (e: Exception) {
                emit(emptyList())
            }
        }
    }

    suspend fun savePromotion(promotion: Promotion): Result<Boolean> {
        return try {
            val docRef = if (promotion.id.isEmpty()) promotionsCollection.document() else promotionsCollection.document(promotion.id)
            val finalPromotion = promotion.copy(id = docRef.id)
            docRef.set(finalPromotion).await()
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun updatePromotionStatus(promotionId: String, isActive: Boolean): Result<Boolean> {
        return try {
            promotionsCollection.document(promotionId).update("isActive", isActive).await()
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
