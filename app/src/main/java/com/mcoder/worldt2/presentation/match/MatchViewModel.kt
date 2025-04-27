package com.mcoder.worldt2.presentation.match

import androidx.lifecycle.ViewModel
import com.mcoder.worldt2.domain.model.Team
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MatchViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<MatchUiState?>(null)
    val uiState: StateFlow<MatchUiState?> = _uiState

    fun startMatch(team1: Team, team2: Team) {
        _uiState.value = MatchUiState(
            firstInnings = InningsState(team = team1),
            secondInnings = InningsState(team = team2)
        )
    }

    fun onIntent(intent: MatchIntent) {
        when (intent) {
            MatchIntent.PlayNextBall -> playNextBall()
        }
    }

    private fun playNextBall() {
        val current = _uiState.value ?: return

        if (current.matchOver) return

        if (current.isFirstInnings) {
            val updated = playBall(current.firstInnings)
            if (updated.ballsRemaining == 0 || updated.wickets == 3) {
                _uiState.value = current.copy(
                    firstInnings = updated,
                    secondInnings = InningsState(
                        team = current.secondInnings.team /*?: Team("Unknown", "")*/
                    ),
                    isFirstInnings = false
                )
            } else {
                _uiState.value = current.copy(firstInnings = updated)
            }
        } else {
            val updated = playBall(current.secondInnings)
            val target = current.firstInnings.runs

            val matchDone =
                updated.runs > target || updated.ballsRemaining == 0 || updated.wickets == 3
            val winner = when {
                updated.runs > target -> updated.team
                matchDone && updated.runs == target -> null
                matchDone -> current.firstInnings.team
                else -> null
            }

            _uiState.value = current.copy(
                secondInnings = updated,
                matchOver = matchDone,
                winner = winner
            )
        }
    }

    private fun playBall(innings: InningsState): InningsState {
        val outcomes = listOf("0", "1", "2", "3", "4", "6", "Out")
        val probabilities = listOf(0.25, 0.25, 0.15, 0.05, 0.15, 0.10, 0.05)

        val outcome = getWeightedOutcome(outcomes, probabilities)

        return when (outcome) {
            "Out" -> innings.copy(
                wickets = innings.wickets + 1,
                ballsPlayed = innings.ballsPlayed + 1,
                ballsRemaining = innings.ballsRemaining - 1,
                currentOutcome = "OUT!"
            )

            else -> {
                val runs = outcome.toInt()
                innings.copy(
                    runs = innings.runs + runs,
                    ballsPlayed = innings.ballsPlayed + 1,
                    ballsRemaining = innings.ballsRemaining - 1,
                    currentOutcome = "$runs run${if (runs != 1) "s" else ""}"
                )
            }
        }
    }

    private fun getWeightedOutcome(values: List<String>, weights: List<Double>): String {
        val rnd = Random.nextDouble()
        var cumulative = 0.0
        for (i in values.indices) {
            cumulative += weights[i]
            if (rnd <= cumulative) return values[i]
        }
        return values.last()
    }
}