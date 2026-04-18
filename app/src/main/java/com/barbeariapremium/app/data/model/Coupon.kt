package com.barbeariapremium.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coupons")
data class Coupon(
    @PrimaryKey val code: String = "",
    val discountPercentage: Int = 0,
    val isActive: Boolean = true,
    val expiryDate: String = "",
    val description: String = ""
)
