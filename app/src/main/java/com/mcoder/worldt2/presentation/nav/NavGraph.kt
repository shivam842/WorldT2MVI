package com.mcoder.worldt2.presentation.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mcoder.worldt2.domain.model.Team
import com.mcoder.worldt2.presentation.match.MatchScreen
import com.mcoder.worldt2.presentation.teamselect.TeamSelectScreen
import com.mcoder.worldt2.presentation.teamselect.TeamSelectScreenWrapper
import kotlinx.serialization.json.Json

@Composable
fun NavGraph(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.TeamSelect.route,
        modifier = modifier
    ) {
        composable(route = Screen.TeamSelect.route) {
            TeamSelectScreenWrapper(
                onTeamsSelected = { team1, team2 ->
                    navController.navigate(Screen.Match.passArgs(team1, team2))
                }
            )
        }

        composable(
            route = Screen.Match.route,
            arguments = listOf()
        ) { backStackEntry ->
            val team1 = backStackEntry.arguments?.getString("team1")?.let {
                Json.decodeFromString<Team>(it)
            }
            val team2 = backStackEntry.arguments?.getString("team2")?.let {
                Json.decodeFromString<Team>(it)
            }

            if (team1 != null && team2 != null) {
                MatchScreen(team1 = team1, team2 = team2)
            }
        }
    }
}