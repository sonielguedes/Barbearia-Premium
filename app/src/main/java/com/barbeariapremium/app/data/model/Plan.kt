package com.barbeariapremium.app.data.model

data class Plan(
    val id: String = "",
    val name: String = "",
    val price: Double = 0.0,
    val benefits: List<String> = java.util.Collections.emptyList(),
    val isPopular: Boolean = false,
    val cashbackPercentage: Double = 0.0
)
