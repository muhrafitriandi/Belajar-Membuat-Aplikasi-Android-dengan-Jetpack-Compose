package com.yandey.pokedex.data.repository.monster

import com.yandey.pokedex.data.FakeMonsterDataSource
import com.yandey.pokedex.data.models.Monster
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MonsterRepositoryImpl : MonsterRepository {
    override fun getAllMonsters(): Flow<List<Monster>> = flowOf(monster)

    private val monster = mutableListOf<Monster>()

    init {
        if (monster.isEmpty()) {
            FakeMonsterDataSource.dummyMonster.forEach {
                monster.add(
                    Monster(
                        it.id,
                        it.name,
                        it.category,
                        it.type,
                        it.gender,
                        it.biology,
                        it.height,
                        it.weakness,
                        it.weight,
                        it.imageUrl,
                        it.owner
                    )
                )
            }
        }
    }
}