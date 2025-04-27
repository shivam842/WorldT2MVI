package com.mcoder.worldt2.domain.model
data class MatchState(
    val teamA: Team,
    val teamB: Team,
    val isTeamABatting: Boolean = true,
    val teamAInning: InningState = InningState(),
    val teamBInning: InningState = InningState(),
    val matchOver: Boolean = false,
    val winner: Team? = null,
    val currentOutcome: BallOutcome? = null
)
