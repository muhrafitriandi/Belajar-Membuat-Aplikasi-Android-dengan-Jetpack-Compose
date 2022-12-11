package com.yandey.pokedex.data.repository.monster

import com.yandey.pokedex.data.models.Monster
import kotlinx.coroutines.flow.Flow

interface MonsterRepository {
    fun searchMonsters(query: String): Flow<List<Monster>>
}