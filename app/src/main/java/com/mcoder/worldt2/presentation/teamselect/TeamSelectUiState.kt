package com.mcoder.worldt2.presentation.teamselect

import com.mcoder.worldt2.domain.model.Team

data class TeamSelectUiState(
    val isLoading: Boolean = false,
    val teamList: List<Team> = emptyList(),
    val selectedTeams: Pair<Team?, Team?>? = null,
    val error: String? = null
)