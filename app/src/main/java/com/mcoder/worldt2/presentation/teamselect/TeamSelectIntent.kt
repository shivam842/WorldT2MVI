package com.mcoder.worldt2.presentation.teamselect

import com.mcoder.worldt2.domain.model.Team

sealed interface TeamSelectIntent {
    data class ToggleTeam(val team: Team) : TeamSelectIntent
    object LoadTeams : TeamSelectIntent
}

/*


sealed class TeamSelectIntent {
    data object LoadTeams : TeamSelectIntent()
    data class ToggleTeam(val team: Team) : TeamSelectIntent()
}*/
