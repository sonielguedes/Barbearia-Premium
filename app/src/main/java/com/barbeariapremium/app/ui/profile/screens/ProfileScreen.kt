package com.barbeariapremium.app.ui.profile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.barbeariapremium.app.data.model.Appointment
import com.barbeariapremium.app.ui.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    viewModel: AuthViewModel,
    onLogout: () -> Unit,
    onNavigateBack: () -> Unit
) {
    val user by viewModel.currentUser.collectAsState()
    val appointments by viewModel.userAppointments.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchUserAppointments()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Meu Perfil", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.Person, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = {
                        viewModel.logout()
                        onLogout()
                    }) {
                        Icon(Icons.Default.ExitToApp, contentDescription = "Sair", tint = MaterialTheme.colorScheme.error)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 24.dp)
        ) {
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(24.dp))
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(60.dp), tint = MaterialTheme.colorScheme.primary)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(user?.name ?: "Usuário", style = MaterialTheme.typography.headlineMedium, color = Color.White)
                    Text(user?.email ?: "", style = MaterialTheme.typography.bodyMedium, color = Color.LightGray)
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }

            item {
                Text(
                    text = "Histórico de Agendamentos",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            if (appointments.isEmpty()) {
                item {
                    Text("Nenhum agendamento encontrado.", color = Color.LightGray)
                }
            } else {
                items(appointments) { appointment ->
                    AppointmentHistoryCard(
                        appointment = appointment,
                        onCancel = { viewModel.cancelAppointment(appointment.id) }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@Composable
fun AppointmentHistoryCard(appointment: Appointment, onCancel: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(appointment.serviceName, style = MaterialTheme.typography.titleMedium, color = Color.White)
                Text(appointment.status, color = when(appointment.status) {
                    "CONFIRMED" -> Color.Green
                    "CANCELLED" -> Color.Red
                    "COMPLETED" -> MaterialTheme.colorScheme.primary
                    else -> Color.Gray
                }, style = MaterialTheme.typography.labelMedium)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text("Com ${appointment.barberName}", style = MaterialTheme.typography.bodySmall, color = Color.LightGray)
            Text("${appointment.date} às ${appointment.time}", style = MaterialTheme.typography.bodyMedium, color = Color.White)
            
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text("R$ ${appointment.price}", style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.primary)
                
                if (appointment.status == "CONFIRMED" || appointment.status == "PENDING") {
                    TextButton(onClick = onCancel) {
                        Text("CANCELAR", color = Color.Red, fontSize = 12.sp)
                    }
                }
            }
        }
    }
}
