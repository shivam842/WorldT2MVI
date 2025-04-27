package com.mcoder.worldt2.ui.customComposables

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mcoder.worldt2.domain.model.Team
import com.mcoder.worldt2.presentation.teamselect.TeamSelectUiState

@Composable
fun AnimatedMatchButton(
    modifier: Modifier,
    enableButton: Boolean,
    uiState: TeamSelectUiState,
    onProceed: (Team, Team) -> Unit
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (enableButton) MaterialTheme.colorScheme.primary else Color(0x66444444),
        label = "buttonBg"
    )

    val contentColor by animateColorAsState(
        targetValue = if (enableButton) Color.White else Color(0xAA212121),
        label = "buttonText"
    )
    Button(
        modifier = modifier,
        enabled = enableButton,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor,
            disabledContainerColor = backgroundColor,
            disabledContentColor = contentColor
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 4.dp
        ),
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        onClick = {
            uiState.selectedTeams?.let { (team1, team2) ->
                onProceed(team1!!, team2!!)
            }
        }
    ) {
        AnimatedContent(
            targetState = enableButton,
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            },
            label = "buttonTextAnimation"
        ) { enabled ->
            Text(if (enabled) "Start Match" else "Pick 2 teams to start")
        }
    }
}
