package com.mathan.portfolio.models

import kotlinx.serialization.Serializable

@Serializable
data class Experience(
    val period: String,
    val title: String,
    val company: String,
    val location: String
)
