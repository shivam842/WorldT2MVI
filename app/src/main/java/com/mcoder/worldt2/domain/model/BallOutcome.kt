package com.mcoder.worldt2.domain.model

data class BallOutcome(
    val resultText: String, // "4", "Out", "Wide", etc.
    val runs: Int = 0,
    val isOut: Boolean = false,
    val isExtra: Boolean = false,
    val isNoBall: Boolean = false
)
