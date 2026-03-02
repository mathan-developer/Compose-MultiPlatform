package com.mathan.portfolio.models

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val id: String,
    val title: String,
    val summary: String,
    val description: String? = null,
    val technologies: List<String> = emptyList(),
    val url: String? = null,
    val repoUrl: String? = null
)
