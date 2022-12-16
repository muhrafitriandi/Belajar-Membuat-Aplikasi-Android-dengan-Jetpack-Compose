package com.yandey.pokedex.di

import android.content.Context
import androidx.room.Room
import com.yandey.pokedex.data.local.room.MonsterDao
import com.yandey.pokedex.data.local.room.PokedexDatabase
import com.yandey.pokedex.utils.ConstDB.POKEDEX_DB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): PokedexDatabase =
        Room.databaseBuilder(
            context,
            PokedexDatabase::class.java,
            POKEDEX_DB
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun providesMonsterDao(pokedexDatabase: PokedexDatabase): MonsterDao =
        pokedexDatabase.monsterDao()
}