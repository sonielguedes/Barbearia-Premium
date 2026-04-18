package com.barbeariapremium.app.ui.admin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.barbeariapremium.app.ui.theme.*
import com.barbeariapremium.app.ui.viewmodel.AdminViewModel
import com.barbeariapremium.app.ui.viewmodel.BarberRanking
import com.barbeariapremium.app.ui.viewmodel.ServiceStats
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminDashboardScreen(
    onNavigateBack: () -> Unit,
    onManagePromotions: () -> Unit,
    onManageSchedule: () -> Unit,
    onManageMemberships: () -> Unit,
    onManageBarbers: () -> Unit,
    viewModel: AdminViewModel = hiltViewModel()
) {
    val stats by viewModel.stats.collectAsState()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(
                        "COMMAND CENTER", 
                        style = MaterialTheme.typography.labelLarge.copy(letterSpacing = 4.sp, color = GoldPrimary)
                    ) 
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar", tint = WhitePremium)
                    }
                },
                actions = {
                    IconButton(onClick = { viewModel.generateMonthlyReport(context) }) {
                        Icon(Icons.Default.PictureAsPdf, contentDescription = "Relatório", tint = GoldPrimary)
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
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(bottom = 32.dp, top = 16.dp)
        ) {
            // Seção de Receita
            item {
                RevenueOverview(stats.monthlyRevenue, stats.dailyRevenue)
            }

            // Cards de Métricas Rápidas
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    MetricMiniCard(
                        modifier = Modifier.weight(1f),
                        label = "Agendamentos",
                        value = stats.todayAppointments.toString(),
                        icon = Icons.Default.Event,
                        color = GoldPrimary
                    )
                    MetricMiniCard(
                        modifier = Modifier.weight(1f),
                        label = "Ticket Médio",
                        value = "R$ ${String.format("%.0f", stats.averageTicket)}",
                        icon = Icons.Default.TrendingUp,
                        color = GreenSuccess
                    )
                    MetricMiniCard(
                        modifier = Modifier.weight(1f),
                        label = "Clientes Ativos",
                        value = stats.activeCustomers.toString(),
                        icon = Icons.Default.People,
                        color = Color(0xFF64B5F6)
                    )
                }
            }

            // Serviços Mais Vendidos
            item {
                SectionHeader(title = "SERVIÇOS EM ALTA", icon = Icons.Default.AutoAwesome)
            }

            items(stats.topServices.take(3)) { service ->
                StatRow(label = service.serviceName, value = "${service.count}x", progress = service.count / 100f)
            }

            // Atalhos de Gestão
            item {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    PremiumButton(
                        text = "GERENCIAR PROMOÇÕES",
                        onClick = onManagePromotions
                    )
                    PremiumButton(
                        text = "GERENCIAR MEMBROS",
                        onClick = onManageMemberships
                    )
                    PremiumButton(
                        text = "GESTÃO DE AGENDA",
                        onClick = onManageSchedule
                    )
                    PremiumButton(
                        text = "CONTROLE DE EQUIPE",
                        onClick = onManageBarbers
                    )
                }
            }

            // Ranking de Barbeiros
            item {
                Text(
                    "RANKING DE PERFORMANCE",
                    style = MaterialTheme.typography.labelSmall.copy(color = GreyLight, letterSpacing = 2.sp)
                )
            }

            items(stats.topBarbers) { barber ->
                BarberPerformanceCard(barber)
            }
        }
    }
}

@Composable
fun RevenueOverview(monthly: Double, daily: Double) {
    PremiumCard {
        Column(modifier = Modifier.padding(24.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        "RECEITA MENSAL",
                        style = MaterialTheme.typography.labelSmall.copy(color = GoldPrimary, letterSpacing = 2.sp)
                    )
                    Text(
                        "R$ ${String.format(Locale.US, "%,.2f", monthly)}",
                        style = MaterialTheme.typography.headlineLarge.copy(color = WhitePremium, fontWeight = FontWeight.ExtraBold)
                    )
                }
                
                // Mini Gráfico de Barras Simulado
                Row(
                    modifier = Modifier.height(40.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    val bars = listOf(0.4f, 0.6f, 0.3f, 0.8f, 0.5f, 0.9f, 0.7f)
                    for (h in bars) {
                        Box(
                            modifier = Modifier
                                .width(6.dp)
                                .fillMaxHeight(h)
                                .clip(RoundedCornerShape(topStart = 2.dp, topEnd = 2.dp))
                                .background(if (h > 0.7f) GoldPrimary else GoldPrimary.copy(alpha = 0.4f))
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Gráfico de Linha Simulado (Visual)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(BlackMatte.copy(alpha = 0.5f))
                    .border(0.5.dp, GreyMedium.copy(alpha = 0.3f), RoundedCornerShape(12.dp))
                    .padding(8.dp)
            ) {
                // Desenho das linhas de grade
                Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxHeight()) {
                    HorizontalDivider(color = GreyMedium.copy(alpha = 0.1f), thickness = 0.5.dp)
                    HorizontalDivider(color = GreyMedium.copy(alpha = 0.1f), thickness = 0.5.dp)
                    HorizontalDivider(color = GreyMedium.copy(alpha = 0.1f), thickness = 0.5.dp)
                }
                
                // Simulação da linha de tendência
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    val points = listOf(0.2f, 0.45f, 0.3f, 0.7f, 0.5f, 0.9f, 0.85f)
                    for (p in points) {
                        Box(
                            modifier = Modifier
                                .width(2.dp)
                                .fillMaxHeight(p)
                                .background(Brush.verticalGradient(listOf(GoldPrimary, Color.Transparent)))
                        )
                    }
                }
                
                Text(
                    "TENDÊNCIA SEMANAL",
                    modifier = Modifier.align(Alignment.TopStart).padding(4.dp),
                    style = MaterialTheme.typography.labelSmall.copy(fontSize = 8.sp, color = GreyLight)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.ArrowUpward, contentDescription = null, tint = GreenSuccess, modifier = Modifier.size(16.dp))
                Text(
                    " Hoje: R$ ${String.format(Locale.US, "%.2f", daily)}",
                    style = MaterialTheme.typography.bodyMedium.copy(color = GreenSuccess)
                )
            }
        }
    }
}

@Composable
fun MetricMiniCard(modifier: Modifier, label: String, value: String, icon: ImageVector, color: Color) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(SurfaceDark)
            .border(0.5.dp, GreyMedium, RoundedCornerShape(20.dp))
            .padding(16.dp)
    ) {
        Column {
            Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.height(12.dp))
            Text(value, style = MaterialTheme.typography.titleLarge.copy(color = WhitePremium, fontWeight = FontWeight.Bold))
            Text(label, style = MaterialTheme.typography.labelSmall.copy(color = GreyLight))
        }
    }
}

@Composable
fun SectionHeader(title: String, icon: ImageVector) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null, tint = GoldPrimary, modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            title,
            style = MaterialTheme.typography.labelSmall.copy(color = GreyLight, letterSpacing = 2.sp)
        )
    }
}

@Composable
fun StatRow(label: String, value: String, progress: Float) {
    val coercedProgress = if (progress < 0.1f) 0.1f else if (progress > 1f) 1f else progress
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(label, color = WhitePremium, fontSize = 14.sp)
            Text(value, color = GoldPrimary, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(
            progress = coercedProgress,
            modifier = Modifier.fillMaxWidth().height(4.dp).clip(RoundedCornerShape(2.dp)),
            color = GoldPrimary,
            trackColor = SurfaceDark
        )
    }
}

@Composable
fun BarberPerformanceCard(barber: BarberRanking) {
    PremiumCard(modifier = Modifier.padding(vertical = 4.dp)) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(40.dp).clip(RoundedCornerShape(10.dp)).background(GoldDark),
                contentAlignment = Alignment.Center
            ) {
                Text(barber.barberName.take(1), color = WhitePremium, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(barber.barberName, color = WhitePremium, fontWeight = FontWeight.Bold)
                Text("${barber.appointmentCount} atendimentos", color = GreyLight, fontSize = 12.sp)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text("R$ ${String.format(Locale.US, "%.2f", barber.totalRevenue)}", color = GoldPrimary, fontWeight = FontWeight.Bold)
                Text("Comissão: R$ ${String.format(Locale.US, "%.2f", barber.commission)}", color = GreyLight, fontSize = 10.sp)
            }
        }
    }
}
