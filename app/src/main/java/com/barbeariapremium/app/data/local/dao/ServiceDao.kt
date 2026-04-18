package com.barbeariapremium.app.data.local.dao

import androidx.room.*
import com.barbeariapremium.app.data.model.Service
import kotlinx.coroutines.flow.Flow

@Dao
interface ServiceDao {
    @Query("SELECT * FROM services")
    fun getAllServices(): Flow<List<Service>>

    @Query("SELECT * FROM services")
    suspend fun getAllServicesList(): List<Service>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertServices(services: List<Service>)

    @Query("DELETE FROM services")
    suspend fun deleteAllServices()
}
