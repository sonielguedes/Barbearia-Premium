@file:OptIn(ExperimentalMaterial3Api::class)

package com.barbeariapremium.app.ui.booking.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CalendarMonth
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
import com.barbeariapremium.app.data.model.Service
import com.barbeariapremium.app.ui.theme.*
import com.barbeariapremium.app.ui.viewmodel.BookingViewModel
import java.util.*

@Composable
fun BookingScreen(
    viewModel: BookingViewModel,
    onBookingComplete: () -> Unit,
    onNavigateBack: () -> Unit
) {
    var currentStep by remember { mutableIntStateOf(1) }
    val services by viewModel.services.collectAsState()
    val barbers by viewModel.barbers.collectAsState()
    val selectedService by viewModel.selectedService.collectAsState()
    val selectedBarber by viewModel.selectedBarber.collectAsState()
    val selectedDate by viewModel.selectedDate.collectAsState()
    val selectedTime by viewModel.selectedTime.collectAsState()
    val availableTimes by viewModel.availableTimes.collectAsState()
    val loading by viewModel.bookingLoading.collectAsState()
    val success by viewModel.bookingSuccess.collectAsState()

    LaunchedEffect(success) {
        if (success) onBookingComplete()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(
                        "RESERVA ELITE", 
                        style = MaterialTheme.typography.labelLarge.copy(letterSpacing = 4.sp, color = GoldPrimary)
                    ) 
                },
                navigationIcon = {
                    IconButton(onClick = {
                        if (currentStep > 1) currentStep-- else onNavigateBack()
                    }) {
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
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            BookingProgress(currentStep = currentStep)
            Spacer(modifier = Modifier.height(32.dp))

            AnimatedContent(
                targetState = currentStep,
                transitionSpec = {
                    if (targetState > initialState) {
                        slideInHorizontally { it } + fadeIn() togetherWith slideOutHorizontally { -it } + fadeOut()
                    } else {
                        slideInHorizontally { -it } + fadeIn() togetherWith slideOutHorizontally { it } + fadeOut()
                    }
                }, label = "StepTransition"
            ) { step ->
                Column(modifier = Modifier.fillMaxSize()) {
                    when (step) {
                        1 -> ServiceSelection(services, selectedService) {
                            viewModel.selectService(it)
                            currentStep = 2
                        }
                        2 -> BarberSelection(barbers, selectedBarber) {
                            viewModel.selectBarber(it)
                            currentStep = 3
                        }
                        3 -> DateTimeSelection(
                            selectedDate = selectedDate,
                            selectedTime = selectedTime,
                            availableTimes = availableTimes,
                            onDateSelect = { viewModel.selectDate(it) },
                            onTimeSelect = { viewModel.selectTime(it) },
                            onConfirm = { currentStep = 4 }
                        )
                        4 -> ConfirmationStep(
                            selectedService, selectedBarber, selectedDate, selectedTime, loading,
                            onConfirm = { viewModel.confirmBooking() }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BookingProgress(currentStep: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(4) { index ->
            val step = index + 1
            val isActive = step <= currentStep
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(3.dp)
                    .clip(CircleShape)
                    .background(if (isActive) GoldPrimary else GreyMedium)
            )
        }
    }
}

@Composable
fun ServiceSelection(services: List<Service>, selected: Service?, onSelect: (Service) -> Unit) {
    Text(
        text = "O RITUAL",
        style = MaterialTheme.typography.headlineMedium.copy(color = WhitePremium, fontWeight = FontWeight.ExtraBold)
    )
    Text(
        text = "Selecione o serviço para sua experiência.",
        style = MaterialTheme.typography.bodyMedium.copy(color = GreyLight)
    )
    Spacer(modifier = Modifier.height(24.dp))
    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        items(services) { service ->
            PremiumCard(
                onClick = { onSelect(service) },
                modifier = Modifier.border(
                    width = if (service == selected) 1.dp else 0.dp,
                    color = if (service == selected) GoldPrimary else Color.Transparent,
                    shape = RoundedCornerShape(16.dp)
                )
            ) {
                Row(modifier = Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(service.name, color = WhitePremium, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text("${service.durationMinutes} min • R$ ${service.price}", color = GreyLight, fontSize = 14.sp)
                    }
                    if (service == selected) {
                        Icon(Icons.Default.CheckCircle, contentDescription = null, tint = GoldPrimary)
                    }
                }
            }
        }
    }
}

@Composable
fun BarberSelection(barbers: List<Barber>, selected: Barber?, onSelect: (Barber) -> Unit) {
    Text(
        text = "O ESPECIALISTA",
        style = MaterialTheme.typography.headlineMedium.copy(color = WhitePremium, fontWeight = FontWeight.ExtraBold)
    )
    Text(
        text = "Escolha o profissional que cuidará do seu visual.",
        style = MaterialTheme.typography.bodyMedium.copy(color = GreyLight)
    )
    Spacer(modifier = Modifier.height(24.dp))
    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        items(barbers) { barber ->
            PremiumCard(
                onClick = { onSelect(barber) },
                modifier = Modifier.border(
                    width = if (barber == selected) 1.dp else 0.dp,
                    color = if (barber == selected) GoldPrimary else Color.Transparent,
                    shape = RoundedCornerShape(16.dp)
                )
            ) {
                Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(CircleShape)
                            .background(Brush.linearGradient(listOf(GoldDark, GoldPrimary))),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(barber.name.take(1), color = BlackMatte, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(barber.name, color = WhitePremium, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(barber.specialties, color = GreyLight, fontSize = 14.sp)
                    }
                    if (barber == selected) {
                        Icon(Icons.Default.CheckCircle, contentDescription = null, tint = GoldPrimary)
                    }
                }
            }
        }
    }
}

@Composable
fun ColumnScope.DateTimeSelection(
    selectedDate: String,
    selectedTime: String,
    availableTimes: List<String>,
    onDateSelect: (String) -> Unit,
    onTimeSelect: (String) -> Unit,
    onConfirm: () -> Unit
) {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState(
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
                calendar.set(Calendar.HOUR_OF_DAY, 0)
                calendar.set(Calendar.MINUTE, 0)
                calendar.set(Calendar.SECOND, 0)
                calendar.set(Calendar.MILLISECOND, 0)
                return utcTimeMillis >= calendar.timeInMillis
            }
        }
    )

    Text(
        text = "O MOMENTO",
        style = MaterialTheme.typography.headlineMedium.copy(color = WhitePremium, fontWeight = FontWeight.ExtraBold)
    )
    Spacer(modifier = Modifier.height(24.dp))

    PremiumCard(onClick = { showDatePicker = true }) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text("DATA SELECIONADA", style = MaterialTheme.typography.labelSmall.copy(color = GreyLight))
                Text(
                    text = if (selectedDate.isEmpty()) "Escolher Data" else selectedDate,
                    style = MaterialTheme.typography.titleMedium.copy(color = if (selectedDate.isEmpty()) GreyMedium else GoldPrimary)
                )
            }
            Icon(Icons.Default.CalendarMonth, contentDescription = null, tint = GoldPrimary)
        }
    }

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(onClick = {
                    datePickerState.selectedDateMillis?.let {
                        val sdf = java.text.SimpleDateFormat("dd/MM/yyyy", java.util.Locale.getDefault())
                        sdf.timeZone = java.util.TimeZone.getTimeZone("UTC")
                        val date = sdf.format(java.util.Date(it))
                        onDateSelect(date)
                    }
                    showDatePicker = false
                }) { Text("CONFIRMAR", color = GoldPrimary) }
            },
            colors = DatePickerDefaults.colors(containerColor = SurfaceDark)
        ) {
            DatePicker(state = datePickerState)
        }
    }

    Spacer(modifier = Modifier.height(32.dp))

    if (selectedDate.isNotEmpty()) {
        Text("HORÁRIOS DISPONÍVEIS", style = MaterialTheme.typography.labelSmall.copy(color = GreyLight, letterSpacing = 2.sp))
        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.heightIn(max = 300.dp)
        ) {
            items(availableTimes) { t ->
                val isSelected = t == selectedTime
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (isSelected) GoldPrimary else SurfaceDark)
                        .border(0.5.dp, if (isSelected) Color.Transparent else GreyMedium, RoundedCornerShape(12.dp))
                        .clickable { onTimeSelect(t) }
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        t,
                        color = if (isSelected) BlackMatte else WhitePremium,
                        fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Medium
                    )
                }
            }
        }
    }

    Spacer(modifier = Modifier.weight(1f))
    PremiumButton(
        text = "AVANÇAR",
        onClick = onConfirm,
        enabled = selectedDate.isNotEmpty() && selectedTime.isNotEmpty()
    )
    Spacer(modifier = Modifier.height(24.dp))
}

@Composable
fun ColumnScope.ConfirmationStep(service: Service?, barber: Barber?, date: String, time: String, loading: Boolean, onConfirm: () -> Unit) {
    Text(
        text = "CONFIRMAÇÃO",
        style = MaterialTheme.typography.headlineMedium.copy(color = WhitePremium, fontWeight = FontWeight.ExtraBold)
    )
    Spacer(modifier = Modifier.height(24.dp))

    // Ticket Design
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(Brush.linearGradient(listOf(SurfaceDark, BlackMatte)))
            .border(0.5.dp, GoldPrimary.copy(alpha = 0.3f), RoundedCornerShape(24.dp))
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text("RESUMO DA EXPERIÊNCIA", style = MaterialTheme.typography.labelSmall.copy(color = GoldPrimary, letterSpacing = 2.sp))
            Spacer(modifier = Modifier.height(24.dp))
            
            DetailRowPremium("SERVIÇO", service?.name ?: "")
            DetailRowPremium("ESPECIALISTA", barber?.name ?: "")
            DetailRowPremium("DATA", date)
            DetailRowPremium("HORÁRIO", time)
            
            Spacer(modifier = Modifier.height(24.dp))
            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(GreyMedium))
            Spacer(modifier = Modifier.height(24.dp))
            
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("INVESTIMENTO", style = MaterialTheme.typography.labelLarge.copy(color = WhitePremium))
                Text("R$ ${service?.price ?: "0,00"}", style = MaterialTheme.typography.headlineSmall.copy(color = GoldPrimary, fontWeight = FontWeight.ExtraBold))
            }
        }
    }

    Spacer(modifier = Modifier.weight(1f))
    
    if (loading) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(color = GoldPrimary)
        }
    } else {
        PremiumButton(
            text = "CONFIRMAR RESERVA",
            onClick = onConfirm
        )
    }
    Spacer(modifier = Modifier.height(24.dp))
}

@Composable
fun DetailRowPremium(label: String, value: String) {
    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        Text(label, style = MaterialTheme.typography.labelSmall.copy(color = GreyLight, fontSize = 10.sp))
        Text(value, style = MaterialTheme.typography.bodyLarge.copy(color = WhitePremium, fontWeight = FontWeight.Bold))
    }
}
