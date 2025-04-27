package com.mcoder.worldt2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TeamEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun teamDao(): TeamDao
}