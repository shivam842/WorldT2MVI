package com.mcoder.worldt2.di

import com.mcoder.worldt2.data.repository.TeamRepositoryImpl
import com.mcoder.worldt2.domain.repository.TeamRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTeamRepository(
        impl: TeamRepositoryImpl
    ): TeamRepository

}