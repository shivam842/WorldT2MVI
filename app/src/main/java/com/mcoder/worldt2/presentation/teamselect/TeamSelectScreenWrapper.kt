package com.mcoder.worldt2.presentation.teamselect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.mcoder.worldt2.domain.model.Team

@Composable
fun TeamSelectScreenWrapper(
    onTeamsSelected: (Team, Team) -> Unit
) {
    val viewModel: TeamSelectViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.onIntent(TeamSelectIntent.LoadTeams)
    }

    TeamSelectScreen(
        uiState = uiState,
        onIntent = viewModel::onIntent,
        onProceed = onTeamsSelected
    )
}