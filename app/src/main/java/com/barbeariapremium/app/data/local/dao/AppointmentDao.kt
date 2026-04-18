package com.barbeariapremium.app.data.local.dao

import androidx.room.*
import com.barbeariapremium.app.data.model.Appointment
import kotlinx.coroutines.flow.Flow

@Dao
interface AppointmentDao {
    @Query("SELECT * FROM appointments WHERE userId = :userId ORDER BY date DESC, time DESC")
    fun getUserAppointments(userId: String): Flow<List<Appointment>>

    @Query("SELECT * FROM appointments ORDER BY date DESC, time DESC")
    fun getAllAppointments(): Flow<List<Appointment>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAppointments(appointments: List<Appointment>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAppointment(appointment: Appointment)

    @Update
    suspend fun updateAppointment(appointment: Appointment)

    @Query("DELETE FROM appointments WHERE id = :id")
    suspend fun deleteAppointment(id: String)

    @Query("DELETE FROM appointments")
    suspend fun deleteAllAppointments()
}
