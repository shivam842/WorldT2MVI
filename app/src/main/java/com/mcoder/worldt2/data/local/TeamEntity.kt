package com.mcoder.worldt2.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teams")
data class TeamEntity(
    @PrimaryKey val name: String,
    val flagUrl: String
)
