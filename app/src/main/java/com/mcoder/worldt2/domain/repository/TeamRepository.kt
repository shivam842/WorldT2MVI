package com.mcoder.worldt2.domain.repository

import com.mcoder.worldt2.domain.model.Team

interface TeamRepository {
    suspend fun getAllTeams(): List<Team>
}
