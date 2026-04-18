package com.barbeariapremium.app.ui.admin.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.barbeariapremium.app.ui.viewmodel.AdminViewModel
import com.barbeariapremium.app.ui.viewmodel.CustomerRanking
import com.barbeariapremium.app.ui.viewmodel.ServiceStats
import com.barbeariapremium.app.data.model.Appointment
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminScreen(
    onNavigateBack: () -> Unit,
    onNavigateToBarbers: () -> Unit,
    onNavigateToPromotions: () -> Unit,
    viewModel: AdminViewModel = hiltViewModel()
) {
    val stats by viewModel.stats.collectAsState()
    val appointments by viewModel.allAppointments.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dashboard Admin", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Seção de KPIs
            item {
                Text("Visão Geral", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    StatCard(
                        title = "Hoje",
                        value = "R$ ${String.format(Locale.US, "%.2f", stats.dailyRevenue)}",
                        icon = Icons.Default.MonetizationOn,
                        modifier = Modifier.weight(1f)
                    )
                    StatCard(
                        title = "Semanal",
                        value = "R$ ${String.format(Locale.US, "%.2f", stats.weeklyRevenue)}",
                        icon = Icons.Default.CalendarViewWeek,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            item {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    StatCard(
                        title = "Mensal",
                        value = "R$ ${String.format(Locale.US, "%.2f", stats.monthlyRevenue)}",
                        icon = Icons.Default.Payments,
                        modifier = Modifier.weight(1f)
                    )
                    StatCard(
                        title = "Ticket Médio",
                        value = "R$ ${String.format(Locale.US, "%.2f", stats.averageTicket)}",
                        icon = Icons.AutoMirrored.Filled.TrendingUp,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            item {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    StatCard(
                        title = "Clientes Ativos",
                        value = stats.activeCustomers.toString(),
                        icon = Icons.Default.People,
                        modifier = Modifier.weight(1f)
                    )
                    StatCard(
                        title = "Agendamentos",
                        value = stats.todayAppointments.toString(),
                        icon = Icons.Default.Event,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            // Top Serviços
            if (stats.topServices.isNotEmpty()) {
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Serviços mais Vendidos", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                }
                items(stats.topServices.take(3)) { service ->
                    ServiceStatItem(service)
                }
            }

            // Top Clientes
            if (stats.topCustomers.isNotEmpty()) {
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Melhores Clientes", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                }
                items(stats.topCustomers.take(3)) { customer ->
                    CustomerStatItem(customer)
                }
            }

            // Próximos Agendamentos
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text("Últimos Agendamentos", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }

            val recentAppointments = appointments.take(10)
            items(recentAppointments) { appointment ->
                AppointmentAdminCard(appointment)
            }

            // Ações Rápidas
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text("Ações Rápidas", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                QuickActionRow(
                    onNavigateToBarbers = onNavigateToBarbers,
                    onNavigateToPromotions = { /* Navegação para promoções */ }
                )
            }
        }
    }
}

@Composable
fun StatCard(title: String, value: String, icon: ImageVector, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
            Text(title, fontSize = 12.sp, color = Color.Gray)
            Text(value, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun AppointmentAdminCard(appointment: Appointment) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(appointment.userName, fontWeight = FontWeight.Bold)
                Text("${appointment.serviceName} - ${appointment.time}", fontSize = 14.sp)
                Text(appointment.date, fontSize = 12.sp, color = Color.Gray)
            }
            Text(
                "R$ ${String.format(Locale.US, "%.2f", appointment.price)}",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun ServiceStatItem(service: ServiceStats) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier.padding(12.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(service.serviceName, fontWeight = FontWeight.Medium)
            Text("${service.count} agendamentos", color = MaterialTheme.colorScheme.primary)
        }
    }
}

@Composable
fun CustomerStatItem(customer: CustomerRanking) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier.padding(12.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(customer.customerName, fontWeight = FontWeight.Bold)
                Text("${customer.appointmentCount} visitas", fontSize = 12.sp, color = Color.Gray)
            }
            Text(
                "R$ ${String.format(Locale.US, "%.2f", customer.totalSpent)}",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4CAF50)
            )
        }
    }
}

@Composable
fun QuickActionRow(
    onNavigateToBarbers: () -> Unit = {},
    onNavigateToPromotions: () -> Unit = {}
) {
    var showBlockDialog by remember { mutableStateOf(false) }
    val viewModel: AdminViewModel = hiltViewModel()

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Button(onClick = onNavigateToBarbers, modifier = Modifier.weight(1f)) {
            Icon(Icons.Default.Groups, contentDescription = null)
            Spacer(modifier = Modifier.width(4.dp))
            Text("Equipe", fontSize = 12.sp)
        }
        Button(onClick = onNavigateToPromotions, modifier = Modifier.weight(1f)) {
            Icon(Icons.Default.LocalOffer, contentDescription = null)
            Spacer(modifier = Modifier.width(4.dp))
            Text("Promo", fontSize = 12.sp)
        }
        Button(onClick = { showBlockDialog = true }, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)) {
            Icon(Icons.Default.Block, contentDescription = null)
            Spacer(modifier = Modifier.width(4.dp))
            Text("Bloquear", fontSize = 12.sp)
        }
    }

    if (showBlockDialog) {
        BlockScheduleDialog(
            onDismiss = { showBlockDialog = false },
            onConfirm = { barberId, barberName, date, time ->
                viewModel.blockSchedule(barberId, barberName, date, time)
                showBlockDialog = false
            }
        )
    }
}

@Composable
fun BlockScheduleDialog(
    onDismiss: () -> Unit,
    onConfirm: (String, String, String, String) -> Unit
) {
    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var barberId by remember { mutableStateOf("GENERAL") }
    var barberName by remember { mutableStateOf("Todos") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Bloquear Horário") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Isso impedirá agendamentos de clientes neste horário.")
                OutlinedTextField(value = date, onValueChange = { date = it }, label = { Text("Data (dd/MM/yyyy)") })
                OutlinedTextField(value = time, onValueChange = { time = it }, label = { Text("Horário (HH:mm)") })
                OutlinedTextField(value = barberName, onValueChange = { barberName = it }, label = { Text("Nome do Barbeiro ou 'Todos'") })
            }
        },
        confirmButton = {
            Button(onClick = { onConfirm(barberId, barberName, date, time) }) {
                Text("Bloquear")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Cancelar") }
        }
    )
}
