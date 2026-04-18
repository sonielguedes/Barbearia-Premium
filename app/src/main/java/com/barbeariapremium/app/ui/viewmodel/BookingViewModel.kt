package com.barbeariapremium.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barbeariapremium.app.data.local.dao.CouponDao
import com.barbeariapremium.app.data.model.Appointment
import com.barbeariapremium.app.data.model.Barber
import com.barbeariapremium.app.data.model.Coupon
import com.barbeariapremium.app.data.model.Service
import com.barbeariapremium.app.data.repository.AppointmentRepository
import com.barbeariapremium.app.data.repository.AuthRepository
import com.barbeariapremium.app.data.repository.BarberRepository
import com.barbeariapremium.app.data.repository.ServiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    private val appointmentRepository: AppointmentRepository,
    private val serviceRepository: ServiceRepository,
    private val barberRepository: BarberRepository,
    private val authRepository: AuthRepository,
    private val couponDao: CouponDao // Injetado para gerenciar cupons
) : ViewModel() {

    private val _services = MutableStateFlow<List<Service>>(emptyList())
    val services: StateFlow<List<Service>> = _services

    private val _barbers = MutableStateFlow<List<Barber>>(emptyList())
    val barbers: StateFlow<List<Barber>> = _barbers

    private val _selectedService = MutableStateFlow<Service?>(null)
    val selectedService: StateFlow<Service?> = _selectedService

    private val _selectedBarber = MutableStateFlow<Barber?>(null)
    val selectedBarber: StateFlow<Barber?> = _selectedBarber

    private val _selectedDate = MutableStateFlow<String>("")
    val selectedDate: StateFlow<String> = _selectedDate

    private val _selectedTime = MutableStateFlow<String>("")
    val selectedTime: StateFlow<String> = _selectedTime

    private val _availableTimes = MutableStateFlow<List<String>>(emptyList())
    val availableTimes: StateFlow<List<String>> = _availableTimes

    private val _bookingLoading = MutableStateFlow(false)
    val bookingLoading: StateFlow<Boolean> = _bookingLoading

    private val _bookingSuccess = MutableStateFlow(false)
    val bookingSuccess: StateFlow<Boolean> = _bookingSuccess

    // Estados de Cupom
    private val _appliedCoupon = MutableStateFlow<Coupon?>(null)
    val appliedCoupon: StateFlow<Coupon?> = _appliedCoupon

    private val _couponError = MutableStateFlow<String?>(null)
    val couponError: StateFlow<String?> = _couponError

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            try {
                serviceRepository.fetchAndCacheServices()
                barberRepository.fetchAndCacheBarbers()

                var currentServices = serviceRepository.getServices()
                if (currentServices.isEmpty()) {
                    serviceRepository.addService(Service(name = "Corte de Cabelo", price = 35.0, durationMinutes = 30, description = "Corte clássico"))
                    serviceRepository.addService(Service(name = "Barba", price = 25.0, durationMinutes = 20, description = "Barba completa"))
                    serviceRepository.fetchAndCacheServices()
                    currentServices = serviceRepository.getServices()
                }
                _services.value = currentServices

                var currentBarbers = barberRepository.getBarbers()
                if (currentBarbers.isEmpty()) {
                    barberRepository.addBarber(Barber(name = "João Silva", specialties = "Corte e Barba", rating = 4.9f))
                    barberRepository.addBarber(Barber(name = "Pedro Santos", specialties = "Degradê", rating = 4.8f))
                    barberRepository.fetchAndCacheBarbers()
                    currentBarbers = barberRepository.getBarbers()
                }
                _barbers.value = currentBarbers
            } catch (e: Exception) {
                android.util.Log.e("BookingViewModel", "Error loading data", e)
            }
        }
    }

    fun applyCoupon(code: String) {
        if (code.isEmpty()) return
        viewModelScope.launch {
            val coupon = couponDao.getValidCoupon(code.uppercase())
            if (coupon != null) {
                _appliedCoupon.value = coupon
                _couponError.value = null
            } else {
                _appliedCoupon.value = null
                _couponError.value = "Cupom inválido ou expirado"
            }
        }
    }

    fun removeCoupon() {
        _appliedCoupon.value = null
        _couponError.value = null
    }

    fun calculateTotalPrice(): Double {
        val basePrice = _selectedService.value?.price ?: 0.0
        val discount = _appliedCoupon.value?.discountPercentage ?: 0
        return basePrice * (1 - (discount / 100.0))
    }

    fun selectService(service: Service) { _selectedService.value = service }
    
    fun selectBarber(barber: Barber) { 
        _selectedBarber.value = barber
        updateAvailableTimes()
    }

    fun selectDate(date: String) {
        try {
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val selectedDateObj = sdf.parse(date)
            val todayStr = sdf.format(Date())
            val todayObj = sdf.parse(todayStr)

            if (selectedDateObj != null && todayObj != null && selectedDateObj.before(todayObj)) {
                return
            }

            _selectedDate.value = date
            _selectedTime.value = ""
            updateAvailableTimes()
        } catch (e: Exception) {
            android.util.Log.e("BookingViewModel", "Error selecting date", e)
        }
    }

    fun selectTime(time: String) { _selectedTime.value = time }

    private fun updateAvailableTimes() {
        val barberId = _selectedBarber.value?.id ?: return
        val date = _selectedDate.value
        if (date.isEmpty()) return

        viewModelScope.launch {
            val booked = appointmentRepository.getBarberAppointments(barberId, date)
            val bookedTimes = booked.map { it.time }
            val allTimes = listOf("09:00", "10:00", "11:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00")
            
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val todayStr = sdf.format(Date())
            
            val filteredTimes = if (date == todayStr) {
                val timeSdf = SimpleDateFormat("HH:mm", Locale.getDefault())
                val nowTime = timeSdf.format(Date())
                allTimes.filter { it > nowTime && it !in bookedTimes }
            } else {
                allTimes.filter { it !in bookedTimes }
            }
            
            _availableTimes.value = filteredTimes
        }
    }

    fun confirmBooking() {
        val user = authRepository.getCurrentUser() ?: return
        val service = _selectedService.value ?: return
        val barber = _selectedBarber.value ?: return
        val date = _selectedDate.value
        val time = _selectedTime.value

        if (date.isEmpty() || time.isEmpty()) return

        viewModelScope.launch {
            _bookingLoading.value = true
            val finalPrice = calculateTotalPrice()
            
            val appointment = Appointment(
                id = UUID.randomUUID().toString(),
                userId = user.uid,
                userName = user.displayName ?: "Cliente",
                serviceId = service.id,
                serviceName = service.name,
                barberId = barber.id,
                barberName = barber.name,
                date = date,
                time = time,
                status = "CONFIRMED",
                price = finalPrice
            )
            val result = appointmentRepository.createAppointment(appointment)
            if (result.isSuccess) {
                _bookingSuccess.value = true
            }
            _bookingLoading.value = false
        }
    }
}
