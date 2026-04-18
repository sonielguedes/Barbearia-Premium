package com.barbeariapremium.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appointments")
data class Appointment(
    @PrimaryKey val id: String = "",
    val userId: String = "",
    val userName: String = "",
    val serviceId: String = "",
    val serviceName: String = "",
    val barberId: String = "",
    val barberName: String = "",
    val date: String = "",
    val time: String = "",
    val status: String = "PENDING", // PENDING, CONFIRMED, CANCELLED, COMPLETED
    val price: Double = 0.0,
    val unitId: String = ""
)
