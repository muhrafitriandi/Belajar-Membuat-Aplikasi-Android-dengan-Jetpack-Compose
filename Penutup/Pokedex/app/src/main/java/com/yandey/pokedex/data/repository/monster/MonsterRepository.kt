package com.yandey.pokedex.data.repository.monster

import com.yandey.pokedex.data.models.Monster
import kotlinx.coroutines.flow.Flow

@Suppress("unused")
interface MonsterRepository {

    suspend fun insertMonstersToDB(listMonster: List<Monster>)

    fun getAllMonstersFromDB(): Flow<List<Monster>>

    fun getAllFavoriteMonstersFromDB(): Flow<List<Monster>>

    fun getFavoriteStateMonsterFromDB(id: Long): Flow<Monster>

    fun searchMonstersFromDB(name: String): Flow<List<Monster>>

    suspend fun updateFavoriteMonsterFromDB(id: Long, isFavorite: Boolean)
}