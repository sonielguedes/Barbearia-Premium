package com.barbeariapremium.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "promotions")
data class Promotion(
    @PrimaryKey val id: String = "",
    val title: String = "",
    val description: String = "",
    val imageUrl: String = "",
    val discountPercentage: Int = 0,
    val couponCode: String? = null,
    val isActive: Boolean = true,
    val type: String = "BANNER" // BANNER, COUPON, FLASH_DEAL
)
