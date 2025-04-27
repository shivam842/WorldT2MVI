package com.mcoder.worldt2.presentation.teamselect

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mcoder.worldt2.domain.model.Team
import com.mcoder.worldt2.ui.customComposables.AnimatedMatchButton

@Composable
fun TeamSelectScreen(
    uiState: TeamSelectUiState,
    onIntent: (TeamSelectIntent) -> Unit,
    onProceed: (Team, Team) -> Unit
) {

    val enableButton = uiState.selectedTeams?.let { (team1, team2) ->
        team1 != null && team2 != null && team1 != team2
    } ?: false

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 24.dp, start = 20.dp, end = 20.dp, bottom = 88.dp)
        ) {
            items(uiState.teamList) { team ->
                val isSelected =
                    uiState.selectedTeams?.let { it.first == team || it.second == team } == true

                TeamItem(
                    team = team,
                    isSelected = isSelected,
                    onClick = { onIntent(TeamSelectIntent.ToggleTeam(team)) }
                )
            }
        }

        AnimatedMatchButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .align(Alignment.BottomCenter),
            enableButton = enableButton,
            uiState = uiState,
            onProceed = { team1, team2 -> onProceed(team1, team2) }
        )
    }
}
