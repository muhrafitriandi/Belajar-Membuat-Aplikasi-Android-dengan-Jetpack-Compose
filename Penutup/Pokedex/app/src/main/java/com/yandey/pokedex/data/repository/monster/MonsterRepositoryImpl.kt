package com.yandey.pokedex.data.repository.monster

import com.yandey.pokedex.data.local.room.MonsterDao
import com.yandey.pokedex.data.models.Monster
import com.yandey.pokedex.utils.Mapper.mapEntityToDomain
import com.yandey.pokedex.utils.Mapper.mapListDomainToEntity
import com.yandey.pokedex.utils.Mapper.mapListEntityToDomain
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@Suppress("unused")
class MonsterRepositoryImpl @Inject constructor(
    private val monsterDao: MonsterDao,
) : MonsterRepository {

    override suspend fun insertMonstersToDB(listMonster: List<Monster>) =
        monsterDao.insertMonsters(mapListDomainToEntity(listMonster))

    override fun getAllMonstersFromDB() =
        monsterDao.getAllMonsters().map { monstersEntity ->
            mapListEntityToDomain(monstersEntity)
        }

    override fun getAllFavoriteMonstersFromDB() =
        monsterDao.getAllFavoriteMonsters().map { monstersEntity ->
            mapListEntityToDomain(monstersEntity)
        }

    override fun getFavoriteStateMonsterFromDB(id: Long) =
        monsterDao.getFavoriteStateMonster(id).map { monsterEntity ->
            mapEntityToDomain(monsterEntity)
        }

    override fun searchMonstersFromDB(name: String) =
        monsterDao.searchMonsters(name).map { monstersEntity ->
            mapListEntityToDomain(monstersEntity)
        }

    override suspend fun updateFavoriteMonsterFromDB(id: Long, isFavorite: Boolean) =
        monsterDao.updateFavoriteMonster(id, isFavorite)
}