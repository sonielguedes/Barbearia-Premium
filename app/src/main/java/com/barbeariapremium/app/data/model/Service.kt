package com.barbeariapremium.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "services")
data class Service(
    @PrimaryKey val id: String = "",
    val name: String = "",
    val price: Double = 0.0,
    val durationMinutes: Int = 30,
    val description: String = "",
    val imageUrl: String = "",
    val category: String = "Corte", // Corte, Barba, Combo, Pigmentação, etc.
    val rating: Float = 5.0f,
    val reviewCount: Int = 0,
    val unitId: String = "1"
)
