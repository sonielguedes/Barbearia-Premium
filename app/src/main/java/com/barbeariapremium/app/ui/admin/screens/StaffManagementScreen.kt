package com.barbeariapremium.app.ui.admin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.TrendingUp
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
import com.barbeariapremium.app.ui.viewmodel.BarberRanking

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StaffManagementScreen(
    onNavigateBack: () -> Unit,
    viewModel: AdminViewModel = hiltViewModel()
) {
    val stats by viewModel.stats.collectAsState()
    var showAddDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("GESTÃO DE ELITE", style = MaterialTheme.typography.labelLarge.copy(letterSpacing = 4.sp, color = GoldPrimary)) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar", tint = WhitePremium)
                    }
                },
                actions = {
                    IconButton(onClick = { showAddDialog = true }) {
                        Icon(Icons.Default.Add, contentDescription = "Novo Barbeiro", tint = GoldPrimary)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = BlackMatte)
            )
        },
        containerColor = BlackMatte
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Brush.verticalGradient(listOf(BlackMatte, SurfaceDark)))
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 32.dp, top = 16.dp)
        ) {
            item {
                Text(
                    "EQUIPE E METAS",
                    style = MaterialTheme.typography.labelSmall.copy(color = GreyLight, letterSpacing = 2.sp)
                )
            }

            items(stats.topBarbers) { barber ->
                BarberGoalCard(barber)
            }
        }
    }
}

@Composable
fun BarberGoalCard(barber: BarberRanking) {
    // Simulando uma meta de R$ 5.000 para o exemplo
    val goal = 5000.0
    val progress = (barber.totalRevenue / goal).toFloat().coerceIn(0f, 1f)

    PremiumCard {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(barber.barberName, style = MaterialTheme.typography.titleMedium.copy(color = WhitePremium, fontWeight = FontWeight.Bold))
                    Text("Comissão: ${String.format("%.0f", barber.commission)} (30%)", color = GreyLight, fontSize = 12.sp)
                }
                Icon(Icons.Default.TrendingUp, contentDescription = null, tint = if (progress > 0.8f) GreenSuccess else GoldPrimary)
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Progresso da Meta", color = GreyLight, fontSize = 11.sp)
                Text("R$ ${String.format("%.0f", barber.totalRevenue)} / R$ 5.000", color = WhitePremium, fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier.fillMaxWidth().height(6.dp).clip(RoundedCornerShape(3.dp)),
                color = if (progress > 0.8f) GreenSuccess else GoldPrimary,
                trackColor = GreyMedium
            )
        }
    }
}
