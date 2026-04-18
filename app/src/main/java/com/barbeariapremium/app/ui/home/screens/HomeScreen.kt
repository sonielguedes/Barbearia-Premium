package com.barbeariapremium.app.ui.home.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.barbeariapremium.app.data.model.Service
import com.barbeariapremium.app.ui.theme.*
import com.barbeariapremium.app.ui.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onNavigateToBooking: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToAdmin: () -> Unit,
    onNavigateToAi: () -> Unit,
    onNavigateToLoyalty: () -> Unit,
    onNavigateToMembership: () -> Unit
) {
    val popularServices by viewModel.popularServices.collectAsState()
    val nextAppointment by viewModel.nextAppointment.collectAsState()
    val userSnapshot by viewModel.userState.collectAsState()
    val cashbackBalance by viewModel.cashbackBalance.collectAsState()
    val userStatus by viewModel.userStatus.collectAsState()
    val firebaseUser = viewModel.currentUser

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                                .border(1.dp, MaterialTheme.colorScheme.primary, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = (userSnapshot?.name ?: firebaseUser?.displayName ?: "E").take(1),
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "Olá, ${userSnapshot?.name ?: firebaseUser?.displayName ?: "Elite"}",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Membro $userStatus",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary,
                                letterSpacing = 2.sp
                            )
                        }
                    }
                },
                actions = {
                    if (userSnapshot?.isAdmin == true) {
                        IconButton(onClick = onNavigateToAdmin) {
                            Icon(Icons.Default.Dashboard, contentDescription = "Admin", tint = MaterialTheme.colorScheme.primary)
                        }
                    }
                    IconButton(onClick = onNavigateToProfile) {
                        Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color.White)
                    }
                    IconButton(onClick = onNavigateToAi) {
                        Icon(Icons.Default.AutoAwesome, contentDescription = "IA", tint = MaterialTheme.colorScheme.primary)
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
                Spacer(modifier = Modifier.height(16.dp))
                CashbackCard(balance = cashbackBalance, status = userStatus, onClick = onNavigateToLoyalty)
                Spacer(modifier = Modifier.height(24.dp))
                PromoBanner(onClick = onNavigateToMembership)
                Spacer(modifier = Modifier.height(32.dp))
            }

            item {
                SectionHeader("Próximo Agendamento")
                Spacer(modifier = Modifier.height(16.dp))
                NextAppointmentCard(nextAppointment, onNavigateToBooking)
                Spacer(modifier = Modifier.height(32.dp))
            }

            item {
                SectionHeader("Nossos Especialistas", actionText = "Ver todos", onActionClick = { /* Ver todos */ })
                Spacer(modifier = Modifier.height(16.dp))
                BarberRankingRow(viewModel)
                Spacer(modifier = Modifier.height(32.dp))
            }

            item {
                SectionHeader("Serviços Populares", actionText = "Ver todos", onActionClick = { /* Ver todos */ })
                Spacer(modifier = Modifier.height(16.dp))
            }

            items(popularServices) { service ->
                ServiceCard(service, onNavigateToBooking)
                Spacer(modifier = Modifier.height(16.dp))
            }
            
            item { Spacer(modifier = Modifier.height(24.dp)) }
        }
    }
}

@Composable
fun BarberRankingRow(viewModel: HomeViewModel) {
    val barbers by viewModel.barbers.collectAsState()
    
    androidx.compose.foundation.lazy.LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(end = 24.dp)
    ) {
        items(barbers) { barber ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(80.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF252525))
                        .border(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.5f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(barber.name.take(1), color = Color.White, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(8.dp))
                val firstName = barber.name.split(" ").firstOrNull() ?: barber.name
                Text(
                    text = firstName,
                    color = Color.White,
                    fontSize = 12.sp,
                    maxLines = 1
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFD4AF37), modifier = Modifier.size(10.dp))
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(text = barber.rating.toString(), color = Color.Gray, fontSize = 10.sp)
                }
            }
        }
    }
}

@Composable
fun SectionHeader(title: String, actionText: String? = null, onActionClick: () -> Unit = {}) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        if (actionText != null) {
            Text(
                text = actionText,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 14.sp,
                modifier = Modifier.clickable { onActionClick() }
            )
        }
    }
}

@Composable
fun CashbackCard(balance: String, status: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A))
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text("Seu saldo Cashback", color = Color.Gray, fontSize = 12.sp)
                Text("R$ $balance", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Black)
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Star, contentDescription = null, tint = Color.Black, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(status, color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
fun PromoBanner(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(
                Brush.horizontalGradient(
                    colors = listOf(Color(0xFFD4AF37), Color(0xFF996515))
                )
            )
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.CenterStart)
        ) {
            Text(
                text = "ASSINATURA\nPREMIUM",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black,
                fontWeight = FontWeight.Black,
                lineHeight = 28.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Cortes ilimitados por R$ 149/mês",
                color = Color.Black.copy(alpha = 0.7f),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun NextAppointmentCard(appointment: com.barbeariapremium.app.data.model.Appointment?, onBooking: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onBooking() },
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(1.dp, if (appointment != null) GoldPrimary.copy(alpha = 0.5f) else Color.DarkGray),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A))
    ) {
        if (appointment == null) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    Icons.Default.Event, 
                    contentDescription = null, 
                    tint = GreyMedium, 
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "VOCÊ NÃO TEM AGENDAMENTOS",
                    color = GreyLight,
                    style = MaterialTheme.typography.labelSmall.copy(letterSpacing = 1.sp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = onBooking,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = GoldPrimary)
                ) {
                    Text("AGENDAR AGORA", color = Color.Black, fontWeight = FontWeight.Black, fontSize = 12.sp)
                }
            }
        } else {
            Row(
                modifier = Modifier.padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(SurfaceDark),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            appointment.date.split("/").getOrNull(0) ?: "",
                            color = GoldPrimary,
                            fontWeight = FontWeight.Black,
                            fontSize = 18.sp
                        )
                        Text(
                            appointment.date.split("/").getOrNull(1) ?: "",
                            color = WhitePremium,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                
                Spacer(modifier = Modifier.width(16.dp))
                
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "CONFIRMADO", 
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = GreenSuccess, 
                            fontWeight = FontWeight.Black,
                            letterSpacing = 1.sp
                        )
                    )
                    Text(
                        appointment.serviceName, 
                        color = WhitePremium, 
                        fontWeight = FontWeight.ExtraBold, 
                        fontSize = 18.sp
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.AccessTime, contentDescription = null, tint = GreyLight, modifier = Modifier.size(14.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(appointment.time, color = GreyLight, fontSize = 14.sp)
                    }
                }
                
                Icon(
                    Icons.AutoMirrored.Filled.ArrowForwardIos, 
                    contentDescription = null, 
                    tint = GoldPrimary, 
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Composable
fun ServiceCard(service: Service, onBooking: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onBooking() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF252525)),
                contentAlignment = Alignment.Center
            ) {
                if (service.imageUrl.isNotEmpty()) {
                    // Coil would go here: AsyncImage(model = service.imageUrl, ...)
                    Text(service.name.take(1), color = MaterialTheme.colorScheme.primary, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                } else {
                    Text(service.name.take(1), color = MaterialTheme.colorScheme.primary, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = service.category,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(4.dp))
                            .padding(horizontal = 4.dp, vertical = 2.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFD4AF37), modifier = Modifier.size(12.dp))
                        Text(text = " ${service.rating}", color = Color.Gray, fontSize = 11.sp)
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(service.name, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text("${service.durationMinutes} min • R$ ${service.price}", color = Color.Gray, fontSize = 13.sp)
            }
            IconButton(
                onClick = onBooking,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .size(36.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}
