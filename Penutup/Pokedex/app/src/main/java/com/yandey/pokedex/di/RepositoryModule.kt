package com.yandey.pokedex.di

import com.yandey.pokedex.data.repository.monster.MonsterRepository
import com.yandey.pokedex.data.repository.monster.MonsterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun bindsMonsterRepository(): MonsterRepository = MonsterRepositoryImpl()
}