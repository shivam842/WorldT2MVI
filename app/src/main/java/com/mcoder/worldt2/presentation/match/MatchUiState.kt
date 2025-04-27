package com.mcoder.worldt2.presentation.match

import com.mcoder.worldt2.domain.model.Team

data class InningsState(
    val team: Team,
    val runs: Int = 0,
    val wickets: Int = 0,
    val ballsPlayed: Int = 0,
    val ballsRemaining: Int = 12,
    val currentOutcome: String = ""
)

data class MatchUiState(
    val firstInnings: InningsState,
    val secondInnings: InningsState,
    val isFirstInnings: Boolean = true,
    val matchOver: Boolean = false,
    val winner: Team? = null
)