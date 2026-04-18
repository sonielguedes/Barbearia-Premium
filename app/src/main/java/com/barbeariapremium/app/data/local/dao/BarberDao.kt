package com.barbeariapremium.app.data.local.dao

import androidx.room.*
import com.barbeariapremium.app.data.model.Barber
import kotlinx.coroutines.flow.Flow

@Dao
interface BarberDao {
    @Query("SELECT * FROM barbers")
    fun getAllBarbers(): Flow<List<Barber>>

    @Query("SELECT * FROM barbers")
    suspend fun getAllBarbersList(): List<Barber>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBarber(barber: Barber)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBarbers(barbers: List<Barber>)

    @Query("DELETE FROM barbers WHERE id = :id")
    suspend fun deleteBarberById(id: String)

    @Query("DELETE FROM barbers")
    suspend fun deleteAllBarbers()
}
