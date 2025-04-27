package com.mcoder.worldt2.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mcoder.worldt2.domain.model.Team
import com.mcoder.worldt2.domain.repository.TeamRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : TeamRepository {

    override suspend fun getAllTeams(): List<Team> {
        val jsonString = context.assets.open("teams.json").bufferedReader().use { it.readText() }
        val type = object : TypeToken<List<Team>>() {}.type
        return Gson().fromJson(jsonString, type)
    }
}