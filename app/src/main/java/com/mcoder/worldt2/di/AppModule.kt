package com.mcoder.worldt2.di

import android.content.Context
import androidx.room.Room
import com.mcoder.worldt2.data.local.AppDatabase
import com.mcoder.worldt2.data.local.TeamDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "world_t2.db").build()

    @Provides
    fun provideDao(db: AppDatabase): TeamDao = db.teamDao()

}
