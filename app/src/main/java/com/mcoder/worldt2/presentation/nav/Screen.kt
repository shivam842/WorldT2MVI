package com.mcoder.worldt2.presentation.nav

import com.mcoder.worldt2.domain.model.Team
import kotlinx.serialization.json.Json

sealed class Screen(val route: String) {
    object TeamSelect : Screen("team_select")
    object Match : Screen("match?team1={team1}&team2={team2}") {
        fun passArgs(team1: Team, team2: Team): String {
            val t1 = Json.encodeToString(team1)
            val t2 = Json.encodeToString(team2)
            return "match?team1=$t1&team2=$t2"
        }
    }
}
