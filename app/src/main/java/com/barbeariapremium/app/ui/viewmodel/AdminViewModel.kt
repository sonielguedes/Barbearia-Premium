package com.barbeariapremium.app.ui.viewmodel

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.os.Environment
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barbeariapremium.app.data.model.Appointment
import com.barbeariapremium.app.data.model.Barber
import com.barbeariapremium.app.data.model.Promotion
import com.barbeariapremium.app.data.model.User
import com.barbeariapremium.app.data.repository.AppointmentRepository
import com.barbeariapremium.app.data.repository.BarberRepository
import com.barbeariapremium.app.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

data class BarberRanking(
    val barberName: String,
    val totalRevenue: Double,
    val appointmentCount: Int,
    val commission: Double
)

data class ServiceStats(
    val serviceName: String,
    val count: Int
)

data class CustomerRanking(
    val customerName: String,
    val totalSpent: Double,
    val appointmentCount: Int
)

data class DashboardStats(
    val dailyRevenue: Double = 0.0,
    val weeklyRevenue: Double = 0.0,
    val monthlyRevenue: Double = 0.0,
    val todayAppointments: Int = 0,
    val activeCustomers: Int = 0,
    val averageTicket: Double = 0.0,
    val topBarbers: List<BarberRanking> = emptyList(),
    val topServices: List<ServiceStats> = emptyList(),
    val topCustomers: List<CustomerRanking> = emptyList()
)

@HiltViewModel
class AdminViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val appointmentRepository: AppointmentRepository,
    private val barberRepository: BarberRepository
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    private val _barbers = MutableStateFlow<List<Barber>>(emptyList())
    val barbers: StateFlow<List<Barber>> = _barbers

    private val _stats = MutableStateFlow(DashboardStats())
    val stats: StateFlow<DashboardStats> = _stats

    private val _allAppointments = MutableStateFlow<List<Appointment>>(emptyList())
    val allAppointments: StateFlow<List<Appointment>> = _allAppointments

    private val _promotions = MutableStateFlow<List<Promotion>>(emptyList())
    val promotions: StateFlow<List<Promotion>> = _promotions

    init {
        loadDashboardData()
        loadPromotions()
        loadUsers()
        loadBarbers()
    }

    private fun loadBarbers() {
        viewModelScope.launch {
            barberRepository.getBarbersFlow().collect {
                _barbers.value = it
            }
        }
    }

    fun deleteBarber(id: String) {
        viewModelScope.launch {
            barberRepository.deleteBarber(id)
        }
    }

    fun saveBarber(barber: Barber) {
        viewModelScope.launch {
            barberRepository.updateBarber(barber)
        }
    }

    private fun loadUsers() {
        viewModelScope.launch {
            try {
                _users.value = authRepository.getAllUsers()
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    private fun loadPromotions() {
        viewModelScope.launch {
            appointmentRepository.getPromotionsFlow().collect {
                _promotions.value = it
            }
        }
    }

    private fun loadDashboardData() {
        viewModelScope.launch {
            combine(
                appointmentRepository.getAllAppointmentsFlow(),
                barberRepository.getBarbersFlow()
            ) { appointments, barbers ->
                _allAppointments.value = appointments
                calculateStats(appointments, barbers)
            }.collect { }
        }
    }

    private fun calculateStats(appointments: List<Appointment>, barbers: List<Barber>) {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val today = sdf.format(Date())
        
        val calendar = Calendar.getInstance()
        val currentMonth = String.format(Locale.getDefault(), "%02d/%d", calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR))

        // Faturamento Hoje
        val todayApps = appointments.filter { it.date == today }
        val dailyRev = todayApps.sumOf { it.price }
        
        // Faturamento Semanal
        val calendarWeek = Calendar.getInstance()
        calendarWeek.set(Calendar.DAY_OF_WEEK, calendarWeek.firstDayOfWeek)
        calendarWeek.set(Calendar.HOUR_OF_DAY, 0)
        calendarWeek.set(Calendar.MINUTE, 0)
        calendarWeek.set(Calendar.SECOND, 0)
        val startOfWeek = calendarWeek.time
        
        val weeklyApps = appointments.filter { 
            try {
                val appDate = sdf.parse(it.date)
                appDate != null && appDate.after(startOfWeek) || it.date == today
            } catch (e: Exception) { false }
        }
        val weeklyRev = weeklyApps.sumOf { it.price }
        
        // Faturamento Mensal
        val monthApps = appointments.filter { it.date.contains(currentMonth) }
        val monthlyRev = monthApps.sumOf { it.price }
        
        val uniqueCustomers = appointments.map { it.userId }.distinct().size
        val avgTicket = if (appointments.isNotEmpty()) appointments.sumOf { it.price } / appointments.size else 0.0

        val rankings = barbers.map { barber ->
            val barberApps = appointments.filter { it.barberId == barber.id }
            val revenue = barberApps.sumOf { it.price }
            BarberRanking(
                barberName = barber.name,
                totalRevenue = revenue,
                appointmentCount = barberApps.size,
                commission = revenue * barber.commissionRate
            )
        }.sortedByDescending { it.totalRevenue }

        val serviceStats = appointments.groupBy { it.serviceName }
            .map { ServiceStats(it.key, it.value.size) }
            .sortedByDescending { it.count }

        val customerRankings = appointments.groupBy { it.userId }
            .map { entry: Map.Entry<String, List<Appointment>> ->
                val userApps = entry.value
                CustomerRanking(
                    customerName = if (userApps.isNotEmpty()) userApps[0].userName else "Cliente",
                    totalSpent = userApps.sumOf { it.price },
                    appointmentCount = userApps.size
                )
            }.sortedByDescending { it.totalSpent }

        _stats.value = DashboardStats(
            dailyRevenue = dailyRev,
            weeklyRevenue = weeklyRev,
            monthlyRevenue = monthlyRev,
            todayAppointments = todayApps.size,
            activeCustomers = uniqueCustomers,
            averageTicket = avgTicket,
            topBarbers = rankings,
            topServices = serviceStats,
            topCustomers = customerRankings
        )
    }

    fun addNewBarber(name: String, commissionRate: Double, monthlyGoal: Double) {
        viewModelScope.launch {
            val newBarber = Barber(
                id = "", // Será gerado pelo repository/Firestore
                name = name,
                commissionRate = commissionRate,
                monthlyGoal = monthlyGoal,
                active = true
            )
            barberRepository.addBarber(newBarber)
        }
    }

    fun blockSchedule(barberId: String, barberName: String, date: String, time: String) {
        viewModelScope.launch {
            appointmentRepository.blockSchedule(barberId, barberName, date, time)
        }
    }

    fun addPromotion(promotion: Promotion) {
        viewModelScope.launch {
            appointmentRepository.savePromotion(promotion)
        }
    }

    fun togglePromotion(promotionId: String, isActive: Boolean) {
        viewModelScope.launch {
            appointmentRepository.updatePromotionStatus(promotionId, isActive)
        }
    }

    fun generateMonthlyReport(context: Context) {
        val pdfDocument = PdfDocument()
        val paint = Paint()
        val titlePaint = Paint()

        val pageInfo = PdfDocument.PageInfo.Builder(595, 842, 1).create()
        val page = pdfDocument.startPage(pageInfo)
        val canvas: Canvas = page.canvas

        titlePaint.textSize = 24f
        titlePaint.isFakeBoldText = true
        canvas.drawText("Barbearia Premium - Relatório Mensal", 50f, 50f, titlePaint)

        paint.textSize = 14f
        var yPos = 100f

        val currentStats = _stats.value
        canvas.drawText("Faturamento Mensal: R$ ${String.format(Locale.US, "%.2f", currentStats.monthlyRevenue)}", 50f, yPos, paint)
        yPos += 30f
        canvas.drawText("Ticket Médio: R$ ${String.format(Locale.US, "%.2f", currentStats.averageTicket)}", 50f, yPos, paint)
        yPos += 30f
        canvas.drawText("Total de Clientes Ativos: ${currentStats.activeCustomers}", 50f, yPos, paint)

        yPos += 50f
        titlePaint.textSize = 18f
        canvas.drawText("Comissões por Barbeiro:", 50f, yPos, titlePaint)
        yPos += 30f

        paint.textSize = 12f
        currentStats.topBarbers.forEach { barber ->
            canvas.drawText("${barber.barberName}: R$ ${String.format(Locale.US, "%.2f", barber.commission)} (Total: R$ ${String.format(Locale.US, "%.2f", barber.totalRevenue)})", 50f, yPos, paint)
            yPos += 20f
        }

        pdfDocument.finishPage(page)

        val directory = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        val file = File(directory, "Relatorio_Mensal_${System.currentTimeMillis()}.pdf")

        try {
            pdfDocument.writeTo(FileOutputStream(file))
            Toast.makeText(context, "PDF gerado: ${file.absolutePath}", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            Toast.makeText(context, "Erro ao gerar PDF", Toast.LENGTH_SHORT).show()
        } finally {
            pdfDocument.close()
        }
    }
}
