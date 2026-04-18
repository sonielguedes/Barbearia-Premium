package com.barbeariapremium.app.ui.ai

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.barbeariapremium.app.ui.theme.*
import com.barbeariapremium.app.ui.viewmodel.AiViewModel
import com.barbeariapremium.app.ui.viewmodel.ChatMessage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AiScreen(
    onNavigateBack: () -> Unit,
    viewModel: AiViewModel = hiltViewModel()
) {
    val messages by viewModel.chatMessages.collectAsState()
    val isAnalyzing by viewModel.isAnalyzing.collectAsState()
    val suggestedCuts by viewModel.suggestedCuts.collectAsState()
    val predictions by viewModel.busyHoursPrediction.collectAsState()
    
    var inputText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(
                        "ASSISTENTE IA", 
                        style = MaterialTheme.typography.labelLarge.copy(letterSpacing = 4.sp, color = GoldPrimary)
                    ) 
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar", tint = WhitePremium)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = BlackMatte)
            )
        },
        containerColor = BlackMatte
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Brush.verticalGradient(listOf(BlackMatte, SurfaceDark)))
                .padding(24.dp)
        ) {
            // Seção de Previsão de Horários (Inteligência de Negócio)
            PremiumCard {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = GoldPrimary, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("PREVISÃO DE MOVIMENTO", style = MaterialTheme.typography.labelSmall.copy(color = GoldPrimary, letterSpacing = 2.sp))
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        predictions.forEach { (day, status) ->
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(day.take(3).uppercase(), fontSize = 10.sp, color = GreyLight)
                                Text(
                                    status.uppercase(), 
                                    fontSize = 10.sp, 
                                    fontWeight = FontWeight.Bold, 
                                    color = if (status == "Tranquilo") GreenSuccess else Color.Red
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Chatbot de Atendimento
            LazyColumn(
                modifier = Modifier.weight(1f).fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(messages) { message ->
                    AiChatBubble(message)
                }
                
                if (isAnalyzing) {
                    item {
                        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                            CircularProgressIndicator(color = GoldPrimary, modifier = Modifier.size(24.dp))
                        }
                    }
                }
            }

            // Sugestões Automáticas de Promoções
            if (suggestedCuts.isNotEmpty()) {
                Text(
                    "SUGESTÕES DE ESTILO", 
                    style = MaterialTheme.typography.labelSmall.copy(color = WhitePremium, letterSpacing = 2.sp),
                    modifier = Modifier.padding(vertical = 12.dp)
                )
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    suggestedCuts.forEach { cut ->
                        Surface(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .border(0.5.dp, GoldPrimary, RoundedCornerShape(8.dp)),
                            color = SurfaceDark
                        ) {
                            Text(
                                cut, 
                                color = GoldPrimary, 
                                fontSize = 12.sp, 
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Input Campo de Batalha IA
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(32.dp))
                    .background(SurfaceDark)
                    .border(0.5.dp, GreyMedium, RoundedCornerShape(32.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { viewModel.analyzeFaceShape() }) {
                    Icon(Icons.Default.Face, contentDescription = "Análise Facial", tint = GoldPrimary)
                }
                TextField(
                    value = inputText,
                    onValueChange = { inputText = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Pergunte algo à Elite IA...", color = GreyLight, fontSize = 14.sp) },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = GoldPrimary,
                        focusedTextColor = WhitePremium,
                        unfocusedTextColor = WhitePremium
                    )
                )
                IconButton(
                    onClick = {
                        if (inputText.isNotBlank()) {
                            viewModel.sendMessage(inputText)
                            inputText = ""
                        }
                    },
                    modifier = Modifier.clip(CircleShape).background(GoldPrimary).size(40.dp)
                ) {
                    Icon(Icons.AutoMirrored.Filled.Send, contentDescription = "Enviar", tint = BlackMatte)
                }
            }
        }
    }
}

@Composable
fun AiChatBubble(message: ChatMessage) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        contentAlignment = if (message.isUser) Alignment.CenterEnd else Alignment.CenterStart
    ) {
        Surface(
            color = if (message.isUser) GoldPrimary else SurfaceDark,
            shape = RoundedCornerShape(
                topStart = 16.dp,
                topEnd = 16.dp,
                bottomStart = if (message.isUser) 16.dp else 0.dp,
                bottomEnd = if (message.isUser) 0.dp else 16.dp
            ),
            modifier = if (!message.isUser) Modifier.border(0.5.dp, GreyMedium, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomEnd = 16.dp)) else Modifier
        ) {
            Text(
                text = message.text,
                modifier = Modifier.padding(16.dp),
                color = if (message.isUser) BlackMatte else WhitePremium,
                fontSize = 14.sp,
                fontWeight = if (message.isUser) FontWeight.Bold else FontWeight.Normal
            )
        }
    }
}
