package com.mathan.portfolio.models

import kotlinx.serialization.Serializable

@Serializable
data class Education(
    val degree: String,
    val major: String,
    val institution: String,
    val location: String,
    val period: String
)
