package com.barbeariapremium.app.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barbeariapremium.app.data.model.Appointment
import com.barbeariapremium.app.data.model.User
import com.barbeariapremium.app.data.repository.AppointmentRepository
import com.barbeariapremium.app.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository,
    private val appointmentRepository: AppointmentRepository
) : ViewModel() {

    private val _authState = MutableLiveData<Result<Boolean>?>()
    val authState: LiveData<Result<Boolean>?> = _authState

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser

    val userAppointments: StateFlow<List<Appointment>> = _currentUser
        .flatMapLatest { user ->
            if (user != null) {
                appointmentRepository.getUserAppointmentsFlow(user.uid)
            } else {
                flowOf(emptyList())
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val firebaseUser get() = repository.getCurrentUser()

    init {
        repository.getCurrentUser()?.let { firebaseUser ->
            fetchUserData(firebaseUser.uid)
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loading.value = true
            val result = repository.login(email, password)
            _authState.value = result
            if (result.isSuccess) {
                repository.getCurrentUser()?.let { fetchUserData(it.uid) }
            }
            _loading.value = false
        }
    }

    fun isUserLoggedIn(): Boolean = repository.getCurrentUser() != null

    fun register(email: String, password: String, name: String, phone: String) {
        val user = User(uid = "", name = name, email = email, phone = phone, loyaltyPoints = 0)
        register(user, password)
    }

    fun register(user: User, password: String) {
        viewModelScope.launch {
            _loading.value = true
            _authState.value = null // Limpa o estado anterior
            val result = repository.register(user, password)
            _authState.value = result
            if (result.isSuccess) {
                repository.getCurrentUser()?.let { fetchUserData(it.uid) }
            }
            _loading.value = false
        }
    }

    private fun fetchUserData(uid: String) {
        viewModelScope.launch {
            _currentUser.value = repository.getUserData(uid)
        }
    }

    fun fetchUserAppointments() {
        val uid = repository.getCurrentUser()?.uid ?: return
        viewModelScope.launch {
            appointmentRepository.fetchAndCacheUserAppointments(uid)
        }
    }

    fun cancelAppointment(appointmentId: String) {
        viewModelScope.launch {
            val result = appointmentRepository.updateAppointmentStatus(appointmentId, "CANCELLED")
            if (result.isSuccess) {
                fetchUserAppointments()
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
            _currentUser.value = null
            _authState.value = Result.success(false)
        }
    }
}
