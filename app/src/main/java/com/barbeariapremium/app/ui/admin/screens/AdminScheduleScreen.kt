package com.barbeariapremium.app.ui.admin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.EventAvailable
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
import com.barbeariapremium.app.ui.viewmodel.AdminViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminScheduleScreen(
    onNavigateBack: () -> Unit,
    viewModel: AdminViewModel = hiltViewModel()
) {
    var selectedDate by remember { mutableStateOf("25/10/2023") }
    val times = listOf("09:00", "10:00", "11:00", "12:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00")
    
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("GESTÃO DE AGENDA", style = MaterialTheme.typography.labelLarge.copy(letterSpacing = 4.sp, color = GoldPrimary)) },
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
            Text(
                "DATA SELECIONADA: $selectedDate",
                style = MaterialTheme.typography.labelSmall.copy(color = GoldPrimary, letterSpacing = 2.sp)
            )
            
            Spacer(modifier = Modifier.height(24.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(times) { time ->
                    ScheduleActionRow(time)
                }
            }
        }
    }
}

@Composable
fun ScheduleActionRow(time: String) {
    var isBlocked by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(if (isBlocked) Color(0xFF331111) else SurfaceDark)
            .border(0.5.dp, if (isBlocked) Color.Red.copy(alpha = 0.5f) else GreyMedium, RoundedCornerShape(16.dp))
            .clickable { isBlocked = !isBlocked }
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(time, style = MaterialTheme.typography.titleMedium.copy(color = WhitePremium, fontWeight = FontWeight.Bold))
                Text(
                    if (isBlocked) "HORÁRIO BLOQUEADO" else "HORÁRIO DISPONÍVEL",
                    color = if (isBlocked) Color.Red else GreenSuccess,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Icon(
                imageVector = if (isBlocked) Icons.Default.Block else Icons.Default.EventAvailable,
                contentDescription = null,
                tint = if (isBlocked) Color.Red else GoldPrimary
            )
        }
    }
}
