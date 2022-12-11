package com.yandey.pokedex.data.repository.monster

import com.yandey.pokedex.data.FakeMonsterDataSource
import com.yandey.pokedex.data.models.Monster
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MonsterRepositoryImpl @Inject constructor(
) : MonsterRepository {

    override fun searchMonsters(query: String): Flow<List<Monster>> = flow {
        val data = monster.filter { monster ->
            monster.name.contains(query, ignoreCase = true)
        }
        emit(data)
    }

    override fun getMonsterById(id: Long): Flow<Monster> =
        flowOf(monster.first {
            it.id == id
        })

    private val monster = mutableListOf<Monster>()

    init {
        if (monster.isEmpty()) {
            monster.addAll(FakeMonsterDataSource.dummyMonster)
        }
    }
}