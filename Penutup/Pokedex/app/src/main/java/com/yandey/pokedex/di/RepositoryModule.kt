package com.yandey.pokedex.di

import com.yandey.pokedex.data.repository.monster.MonsterRepository
import com.yandey.pokedex.data.repository.monster.MonsterRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsMonsterRepository(monsterRepositoryImpl: MonsterRepositoryImpl): MonsterRepository
}