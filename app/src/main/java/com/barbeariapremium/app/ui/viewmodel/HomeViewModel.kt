package com.barbeariapremium.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barbeariapremium.app.data.model.Appointment
import com.barbeariapremium.app.data.model.Barber
import com.barbeariapremium.app.data.model.Service
import com.barbeariapremium.app.data.model.User
import com.barbeariapremium.app.data.repository.AppointmentRepository
import com.barbeariapremium.app.data.repository.AuthRepository
import com.barbeariapremium.app.data.repository.BarberRepository
import com.barbeariapremium.app.data.repository.ServiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val appointmentRepository: AppointmentRepository,
    private val serviceRepository: ServiceRepository,
    private val barberRepository: BarberRepository
) : ViewModel() {

    private val _user = authRepository.getLocalUser()
    val currentUser get() = authRepository.getCurrentUser()

    val userState: StateFlow<User?> = _user
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val cashbackBalance: StateFlow<String> = userState.map { 
        val amount = it?.cashbackAmount ?: 0.0
        "%.2f".format(amount).replace(".", ",")
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "0,00")

    val loyaltyPoints: StateFlow<Int> = userState.map { 
        it?.loyaltyPoints ?: 0 
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0)

    val userStatus: StateFlow<String> = userState.map { 
        it?.status ?: "BRONZE" 
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "BRONZE")

    @OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
    val nextAppointment: StateFlow<Appointment?> = _user
        .flatMapLatest { user ->
            if (user != null) {
                appointmentRepository.getUserAppointmentsFlow(user.uid).map { appointments ->
                    appointments
                        .filter { it.status == "CONFIRMED" || it.status == "PENDING" }
                        .sortedBy { it.date + it.time }
                        .firstOrNull()
                }
            } else {
                flowOf(null)
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val popularServices: StateFlow<List<Service>> = serviceRepository.getServicesFlow()
        .map { it.take(5) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val barbers: StateFlow<List<Barber>> = barberRepository.getBarbersFlow()
        .map { list: List<Barber> -> list.sortedByDescending { it.rating } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init {
        fetchHomeData()
    }

    fun fetchHomeData() {
        viewModelScope.launch {
            authRepository.getCurrentUser()?.let { user ->
                authRepository.getUserData(user.uid)
                appointmentRepository.fetchAndCacheUserAppointments(user.uid)
            }
            
            launch {
                val services = serviceRepository.getServices()
                if (services.isEmpty()) {
                    serviceRepository.addService(Service(name = "Corte Razor Elite", price = 45.0, durationMinutes = 40, description = "Corte moderno com acabamento na navalha", category = "Corte", rating = 4.9f))
                    serviceRepository.addService(Service(name = "Barba Lenhador", price = 35.0, durationMinutes = 30, description = "Modelagem e hidratação de barba", category = "Barba", rating = 4.8f))
                    serviceRepository.addService(Service(name = "Combo Master", price = 70.0, durationMinutes = 60, description = "Corte + Barba + Lavagem", category = "Combo", rating = 5.0f))
                    serviceRepository.addService(Service(name = "Sobrancelha Design", price = 20.0, durationMinutes = 15, description = "Design de sobrancelha na pinça ou navalha", category = "Sobrancelha", rating = 4.7f))
                    serviceRepository.addService(Service(name = "Pigmentação Barba", price = 30.0, durationMinutes = 25, description = "Preenchimento de falhas com pigmento", category = "Pigmentação", rating = 4.9f))
                }
            }

            launch {
                val barbers = barberRepository.getBarbers()
                if (barbers.isEmpty()) {
                    barberRepository.addBarber(Barber(name = "Ricardo 'Razer' Silva", specialties = "Degradê e Razor Part", rating = 5.0f))
                    barberRepository.addBarber(Barber(name = "Lucas Mendes", specialties = "Barba e Tesoura", rating = 4.9f))
                }
            }

            serviceRepository.fetchAndCacheServices()
            barberRepository.fetchAndCacheBarbers()
        }
    }
}
