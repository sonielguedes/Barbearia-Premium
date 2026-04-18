package com.barbeariapremium.app.data.repository

import android.util.Log
import com.barbeariapremium.app.data.local.dao.BarberDao
import com.barbeariapremium.app.data.local.prefs.PreferenceManager
import com.barbeariapremium.app.data.model.Barber
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BarberRepository @Inject constructor(
    private val db: FirebaseFirestore,
    private val barberDao: BarberDao,
    private val preferenceManager: PreferenceManager
) {
    private val TAG = "BarberRepository"

    fun getBarbersFlow(): Flow<List<Barber>> = barberDao.getAllBarbers()

    suspend fun fetchAndCacheBarbers() {
        try {
            val unitId = preferenceManager.getSelectedUnitId() ?: "1"
            Log.d(TAG, "Fetching barbers from Firestore for unit: $unitId")
            val snapshot = db.collection("barbers")
                .whereEqualTo("unitId", unitId)
                .whereEqualTo("active", true)
                .get().await()
            Log.d(TAG, "Successfully fetched ${snapshot.size()} barbers")
            val barbers = snapshot.toObjects(Barber::class.java)
            barberDao.deleteAllBarbers()
            barberDao.insertBarbers(barbers)
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching and caching barbers", e)
        }
    }

    suspend fun getBarbers(): List<Barber> {
        return try {
            val unitId = preferenceManager.getSelectedUnitId() ?: "1"
            val snapshot = db.collection("barbers")
                .whereEqualTo("unitId", unitId)
                .whereEqualTo("active", true)
                .get().await()
            val barbers = snapshot.toObjects(Barber::class.java)
            barberDao.deleteAllBarbers()
            barberDao.insertBarbers(barbers)
            barbers
        } catch (e: Exception) {
            Log.e(TAG, "Error getting barbers, falling back to local storage", e)
            // Se falhar o Firestore, retorna o que tem no Room
            barberDao.getAllBarbersList()
        }
    }

    suspend fun addBarber(barber: Barber): Result<Boolean> {
        return try {
            val docRef = if (barber.id == "") db.collection("barbers").document() else db.collection("barbers").document(barber.id)
            val unitId = preferenceManager.getSelectedUnitId() ?: "1"
            val barberWithId = if (barber.id == "") {
                barber.copy(id = docRef.id, unitId = unitId)
            } else {
                barber.copy(unitId = unitId)
            }
            docRef.set(barberWithId).await()
            barberDao.insertBarber(barberWithId)
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun updateBarber(barber: Barber): Result<Boolean> {
        return addBarber(barber)
    }

    suspend fun deleteBarber(barberId: String): Result<Boolean> {
        return try {
            db.collection("barbers").document(barberId).delete().await()
            barberDao.deleteBarberById(barberId)
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
