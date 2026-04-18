package com.barbeariapremium.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barbeariapremium.app.data.repository.AppointmentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ChatMessage(
    val text: String,
    val isUser: Boolean
)

@HiltViewModel
class AiViewModel @Inject constructor(
    private val appointmentRepository: AppointmentRepository
) : ViewModel() {

    private val _chatMessages = MutableStateFlow<List<ChatMessage>>(listOf(
        ChatMessage("Olá! Sou o assistente IA da Barbearia Premium. Como posso ajudar você hoje?", false)
    ))
    val chatMessages: StateFlow<List<ChatMessage>> = _chatMessages

    private val _suggestedCuts = MutableStateFlow<List<String>>(emptyList())
    val suggestedCuts: StateFlow<List<String>> = _suggestedCuts

    private val _isAnalyzing = MutableStateFlow(false)
    val isAnalyzing: StateFlow<Boolean> = _isAnalyzing

    private val _busyHoursPrediction = MutableStateFlow<Map<String, String>>(emptyMap())
    val busyHoursPrediction: StateFlow<Map<String, String>> = _busyHoursPrediction

    init {
        predictBusyHours()
    }

    fun sendMessage(text: String) {
        viewModelScope.launch {
            val userMsg = ChatMessage(text, true)
            _chatMessages.value = _chatMessages.value + userMsg
            
            // Simulação de resposta do Chatbot
            val response = when {
                text.contains("horário", ignoreCase = true) -> "Você pode agendar um horário na tela de agendamentos. Recomendo as terças-feiras, que costumam ser mais tranquilas."
                text.contains("preço", ignoreCase = true) -> "Nossos serviços começam a partir de R$ 25,00. Confira a lista completa na Home."
                text.contains("corte", ignoreCase = true) -> "Posso sugerir um corte se você me enviar uma foto do seu rosto!"
                text.contains("promo", ignoreCase = true) -> "Temos uma promoção automática para você: Use o cupom IA10 para 10% de desconto no seu próximo corte!"
                else -> "Entendi! Deseja saber mais sobre nossos serviços ou agendar um horário?"
            }
            
            _chatMessages.value = _chatMessages.value + ChatMessage(response, false)
        }
    }

    fun analyzeFaceShape() {
        viewModelScope.launch {
            _isAnalyzing.value = true
            // Simulação de análise de IA
            delay(2000L)
            _suggestedCuts.value = listOf("Degradê Moderno", "Social com Tesoura", "Undercut")
            _isAnalyzing.value = false
            
            _chatMessages.value = _chatMessages.value + ChatMessage("Analisei seu formato de rosto! Sugiro os seguintes cortes: Degradê Moderno ou Social com Tesoura.", false)
        }
    }

    private fun predictBusyHours() {
        // Simulação de previsão baseada em dados históricos
        _busyHoursPrediction.value = mapOf(
            "Segunda" to "Tranquilo",
            "Sexta" to "Muito Lotado",
            "Sábado" to "Lotado",
            "Domingo" to "Fechado"
        )
    }
}
