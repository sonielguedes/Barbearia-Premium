package com.barbeariapremium.app.data.model

data class Review(
    val id: String = "",
    val userId: String = "",
    val userName: String = "",
    val barberId: String = "",
    val serviceId: String = "",
    val rating: Int = 0, // 1-5
    val comment: String = "",
    val date: Long = System.currentTimeMillis()
)
