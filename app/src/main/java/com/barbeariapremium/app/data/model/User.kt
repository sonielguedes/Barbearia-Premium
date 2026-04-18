package com.barbeariapremium.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val uid: String = "",
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val isAdmin: Boolean = false,
    val profileImageUrl: String = "",
    val loyaltyPoints: Int = 0,
    val cashbackAmount: Double = 0.0,
    val birthDate: String = "",
    val favoriteBarberId: String = "",
    val address: String = "",
    val status: String = "BRONZE" // BRONZE, SILVER, GOLD, PLATINUM
)
