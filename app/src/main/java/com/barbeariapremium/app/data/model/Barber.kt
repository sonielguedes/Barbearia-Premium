package com.barbeariapremium.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "barbers")
data class Barber(
    @PrimaryKey val id: String = "",
    val name: String = "",
    val photoUrl: String = "",
    val specialties: String = "",
    val rating: Float = 5.0f,
    val active: Boolean = true,
    val commissionRate: Double = 0.5, // 50% por padrão
    val monthlyGoal: Double = 5000.0,
    val unitId: String = "1"
)
