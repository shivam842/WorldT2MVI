package com.mcoder.worldt2.presentation.teamselect

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mcoder.worldt2.domain.model.Team

@Composable
fun TeamSelectScreen(
    uiState: TeamSelectUiState,
    onIntent: (TeamSelectIntent) -> Unit,
    onProceed: (Team, Team) -> Unit
) {
    Scaffold(
        bottomBar = {
            uiState.selectedTeams?.let { (team1, team2) ->
                if (team1 != team2) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        onClick = { onProceed(team1, team2) }
                    ) {
                        Text("Start Match")
                    }
                }
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(uiState.teamList) { team ->
                val isSelected = uiState.selectedTeams?.let { it.first == team || it.second == team } == true

                TeamItem(
                    team = team,
                    isSelected = isSelected,
                    onClick = { onIntent(TeamSelectIntent.ToggleTeam(team)) }
                )
            }
        }
    }
    /*Column {
        Text("Select 2 Teams", style = MaterialTheme.typography.headlineMedium)
        LazyColumn {
            items(uiState.teamList) { team ->
                TeamItem(
                    team = team,
                    isSelected = uiState.selectedTeams.contains(team),
                    onClick = { onIntent(TeamSelectIntent.ToggleTeam(team)) }
                )
            }
        }

        Button(
            enabled = uiState.selectedTeams.size == 2,
            onClick = {
                onProceed(
                    uiState.selectedTeams[0],
                    uiState.selectedTeams[1]
                )
            }
        ) {
            Text("Start Match")
        }
    }*/
}
