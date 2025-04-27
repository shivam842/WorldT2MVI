package com.mcoder.worldt2.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Team(
    val name: String,
    val flag: String
)