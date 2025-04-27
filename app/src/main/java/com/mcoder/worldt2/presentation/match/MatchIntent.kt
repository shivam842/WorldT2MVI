package com.mcoder.worldt2.presentation.match

sealed class MatchIntent {
    data object PlayNextBall : MatchIntent()
}