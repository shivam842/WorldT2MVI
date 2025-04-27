package com.mcoder.worldt2.domain.usecase

import com.mcoder.worldt2.domain.model.Team
import com.mcoder.worldt2.domain.repository.TeamRepository
import javax.inject.Inject

class GetTeamsUseCase @Inject constructor(
    private val repository: TeamRepository
) {
    suspend operator fun invoke(): List<Team> {
        return repository.getAllTeams()
    }
}
