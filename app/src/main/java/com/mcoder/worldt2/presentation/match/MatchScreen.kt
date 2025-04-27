package com.mcoder.worldt2.presentation.match

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mcoder.worldt2.domain.model.Team

@Composable
fun MatchScreen(
    team1: Team,
    team2: Team,
    viewModel: MatchViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.startMatch(team1, team2)
    }

    val state = viewModel.uiState.collectAsState().value ?: return

    val innings = if (state.isFirstInnings) state.firstInnings else state.secondInnings!!

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🏏 ${innings.team.name} Batting", style = MaterialTheme.typography.headlineSmall)
        Text("Runs: ${innings.runs} / ${innings.wickets}")
        Text("Balls: ${innings.ballsPlayed} / 12")
        Text("Last Outcome: ${innings.currentOutcome}")

        if (state.matchOver) {
            Text(
                text = "🎉 Winner: ${state.winner?.name ?: "Match Draw"}",
                style = MaterialTheme.typography.headlineSmall
            )
        } else {
            Button(onClick = { viewModel.onIntent(MatchIntent.PlayNextBall) }) {
                Text("Play Next Ball")
            }
        }
    }
}