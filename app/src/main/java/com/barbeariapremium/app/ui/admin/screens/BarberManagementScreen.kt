package com.barbeariapremium.app.ui.admin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
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
import com.barbeariapremium.app.data.model.Barber
import com.barbeariapremium.app.ui.theme.*
import com.barbeariapremium.app.ui.viewmodel.AdminViewModel
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberManagementScreen(
    viewModel: AdminViewModel,
    onNavigateBack: () -> Unit
) {
    val barbers by viewModel.barbers.collectAsState()
    var showAddDialog by remember { mutableStateOf(false) }
    var barberToEdit by remember { mutableStateOf<Barber?>(null) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(
                        "GESTÃO DE EQUIPE", 
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
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddDialog = true },
                containerColor = GoldPrimary,
                contentColor = Color.Black
            ) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar Barbeiro")
            }
        },
        containerColor = BlackMatte
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Brush.verticalGradient(listOf(BlackMatte, SurfaceDark)))
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(top = 16.dp, bottom = 80.dp)
        ) {
            items(barbers) { barber ->
                BarberAdminCard(
                    barber = barber,
                    onEdit = { barberToEdit = barber },
                    onDelete = { viewModel.deleteBarber(barber.id) }
                )
            }
        }

        if (showAddDialog || barberToEdit != null) {
            BarberDialog(
                barber = barberToEdit,
                onDismiss = { 
                    showAddDialog = false
                    barberToEdit = null
                },
                onSave = { 
                    viewModel.saveBarber(it)
                    showAddDialog = false
                    barberToEdit = null
                }
            )
        }
    }
}

@Composable
fun BarberAdminCard(
    barber: Barber,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(0.5.dp, GreyMedium.copy(alpha = 0.5f), RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(SurfaceDark)
                    .border(1.dp, GoldPrimary.copy(alpha = 0.3f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                val initial = if (barber.name.length > 0) barber.name[0].toString().uppercase(Locale.ROOT) else "?"
                Text(initial, color = GoldPrimary, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(barber.name, color = WhitePremium, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(barber.specialties, color = GreyLight, fontSize = 12.sp)
                Text(
                    "Comissão: ${(barber.commissionRate * 100).toInt()}%",
                    color = GoldPrimary,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Row {
                IconButton(onClick = onEdit) {
                    Icon(Icons.Default.Edit, contentDescription = "Editar", tint = WhitePremium, modifier = Modifier.size(20.dp))
                }
                IconButton(onClick = onDelete) {
                    Icon(Icons.Default.Delete, contentDescription = "Excluir", tint = Color.Red.copy(alpha = 0.7f), modifier = Modifier.size(20.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarberDialog(
    barber: Barber?,
    onDismiss: () -> Unit,
    onSave: (Barber) -> Unit
) {
    var name by remember { mutableStateOf(barber?.name ?: "") }
    var specialties by remember { mutableStateOf(barber?.specialties ?: "") }
    var commission by remember { mutableStateOf(barber?.commissionRate?.toString() ?: "0.5") }

    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = SurfaceDark,
        title = { Text(if (barber == null) "Novo Barbeiro" else "Editar Barbeiro", color = GoldPrimary) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nome") },
                    colors = OutlinedTextFieldDefaults.colors(focusedTextColor = WhitePremium, unfocusedTextColor = WhitePremium)
                )
                OutlinedTextField(
                    value = specialties,
                    onValueChange = { specialties = it },
                    label = { Text("Especialidades") },
                    colors = OutlinedTextFieldDefaults.colors(focusedTextColor = WhitePremium, unfocusedTextColor = WhitePremium)
                )
                OutlinedTextField(
                    value = commission,
                    onValueChange = { commission = it },
                    label = { Text("Taxa de Comissão (ex: 0.5 para 50%)") },
                    colors = OutlinedTextFieldDefaults.colors(focusedTextColor = WhitePremium, unfocusedTextColor = WhitePremium)
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onSave(
                        barber?.copy(
                            name = name,
                            specialties = specialties,
                            commissionRate = commission.toDoubleOrNull() ?: 0.5
                        ) ?: Barber(
                            id = "",
                            name = name,
                            specialties = specialties,
                            commissionRate = commission.toDoubleOrNull() ?: 0.5
                        )
                    )
                },
                colors = ButtonDefaults.buttonColors(containerColor = GoldPrimary)
            ) {
                Text("Salvar", color = Color.Black)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar", color = WhitePremium)
            }
        }
    )
}
