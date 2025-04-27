package com.mcoder.worldt2.domain.model
data class InningState(
    val runs: Int = 0,
    val wickets: Int = 0,
    val balls: Int = 0,
    val overs: Double = 0.0,
    val history: List<BallOutcome> = emptyList(),
    val isCompleted: Boolean = false
)
