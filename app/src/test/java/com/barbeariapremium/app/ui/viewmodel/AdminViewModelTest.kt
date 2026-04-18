package com.barbeariapremium.app.ui.viewmodel

import com.barbeariapremium.app.data.model.Appointment
import com.barbeariapremium.app.data.model.Barber
import com.barbeariapremium.app.data.repository.AppointmentRepository
import com.barbeariapremium.app.data.repository.BarberRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AdminViewModelTest {

    private lateinit var viewModel: AdminViewModel
    private val appointmentRepository = mockk<AppointmentRepository>()
    private val barberRepository = mockk<BarberRepository>()

    @Before
    fun setup() {
        val appointments = listOf(
            Appointment(id = "1", barberId = "B1", price = 100.0, date = "25/10/2023"),
            Appointment(id = "2", barberId = "B1", price = 50.0, date = "25/10/2023")
        )
        val barbers = listOf(
            Barber(id = "B1", name = "Enzo", commissionRate = 0.3)
        )

        every { appointmentRepository.getAllAppointmentsFlow() } returns flowOf(appointments)
        every { barberRepository.getBarbersFlow() } returns flowOf(barbers)
        every { appointmentRepository.getPromotionsFlow() } returns flowOf(emptyList())

        viewModel = AdminViewModel(appointmentRepository, barberRepository)
    }

    @Test
    fun `calculateStats should return correct daily revenue and commission`() = runTest {
        val stats = viewModel.stats.value
        
        // Faturamento Total (100 + 50) = 150
        assertEquals(150.0, stats.dailyRevenue, 0.1)
        
        // Comissão (150 * 0.3) = 45
        val enzoRanking = stats.topBarbers.find { it.barberName == "Enzo" }
        assertEquals(45.0, enzoRanking?.commission ?: 0.0, 0.1)
    }
}
