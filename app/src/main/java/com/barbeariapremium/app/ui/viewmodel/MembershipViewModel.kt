package com.barbeariapremium.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barbeariapremium.app.data.model.Plan
import com.barbeariapremium.app.data.repository.AuthRepository
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Locale
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class MembershipViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _plans = MutableStateFlow<List<Plan>>(emptyList())
    val plans: StateFlow<List<Plan>> = _plans.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        fetchPlans()
    }

    fun fetchPlans() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val snapshot = firestore.collection("plans").get().await()
                val planList = snapshot.toObjects(Plan::class.java)
                
                if (planList.isEmpty()) {
                    val defaultPlans = listOf(
                        Plan("1", "SILVER", 89.90, listOf("1 Corte p/ mês", "5% Cashback", "Reserva prioritária"), false, 5.0),
                        Plan("2", "GOLD", 159.90, listOf("2 Cortes p/ mês", "10% Cashback", "Cerveja ou Café", "Sobrancelha inclusa"), true, 10.0),
                        Plan("3", "DIAMOND", 299.90, listOf("Cortes Ilimitados", "15% Cashback", "Barba inclusa", "Lavagem Premium", "Atendimento VIP"), false, 15.0)
                    )
                    _plans.value = defaultPlans
                    defaultPlans.forEach { firestore.collection("plans").document(it.id).set(it) }
                } else {
                    _plans.value = planList
                }
            } catch (e: Exception) {
                _plans.value = listOf(
                    Plan("1", "SILVER", 89.90, listOf("1 Corte p/ mês", "5% Cashback", "Reserva prioritária"), false, 5.0),
                    Plan("2", "GOLD", 159.90, listOf("2 Cortes p/ mês", "10% Cashback", "Cerveja ou Café", "Sobrancelha inclusa"), true, 10.0)
                )
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun subscribeToPlan(planName: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                // Simulação de processamento de pagamento via PIX (2 segundos)
                kotlinx.coroutines.delay(2000)
                
                val user = authRepository.getCurrentUser()
                if (user != null) {
                    val result = authRepository.updateMembershipStatus(user.uid, planName.uppercase())
                    if (result.isSuccess) {
                        onSuccess()
                    }
                }
            } catch (e: Exception) {
                // Log error
            } finally {
                _isLoading.value = false
            }
        }
    }
}
