package com.mcoder.worldt2.presentation.teamselect

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcoder.worldt2.domain.model.Team
import com.mcoder.worldt2.domain.repository.TeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamSelectViewModel @Inject constructor(
    private val repository: TeamRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(TeamSelectUiState())
    val uiState: StateFlow<TeamSelectUiState> = _uiState

    /*init {

    }*/

    private fun loadTeams() {
        viewModelScope.launch {
            try {
                val teams = repository.getAllTeams()
                Log.e("TAG", "loadTeams: $teams" )
                _uiState.value = _uiState.value.copy(teamList = teams)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = "Failed to load teams")
            }
        }
    }

    fun onIntent(intent: TeamSelectIntent) {
        when (intent) {
            is TeamSelectIntent.ToggleTeam -> toggleTeam(intent.team)
            is TeamSelectIntent.LoadTeams -> loadTeams()
        }
    }

    private fun toggleTeam(team: Team) {
        val current = _uiState.value.selectedTeams

        val newSelection = when {
            current == null -> Pair(team, team) // initial state, both teams same temporarily
            current.first == team -> null // deselect
            current.second == team -> null // deselect
            current.first == current.second -> Pair(current.first, team) // fill second team
            else -> Pair(current.second, team) // replace first with second, add new one
        }

        _uiState.value = _uiState.value.copy(selectedTeams = newSelection)
    }
}
