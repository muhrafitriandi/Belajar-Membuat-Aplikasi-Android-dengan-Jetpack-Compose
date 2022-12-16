package com.yandey.pokedex.utils

import com.yandey.pokedex.data.local.entity.MonsterEntity
import com.yandey.pokedex.data.models.Monster

@Suppress("unused")
object Mapper {

    fun mapListEntityToDomain(listMonsterEntity: List<MonsterEntity>) =
        listMonsterEntity.map { monsterEntity ->
            Monster(
                monsterEntity.id,
                monsterEntity.name,
                monsterEntity.category,
                monsterEntity.types,
                monsterEntity.gender,
                monsterEntity.biology,
                monsterEntity.height,
                monsterEntity.weakness,
                monsterEntity.weight,
                monsterEntity.imageUrl,
                monsterEntity.owner,
                monsterEntity.isFavorite
            )
        }

    fun mapListDomainToEntity(listMonsterEntity: List<Monster>) =
        listMonsterEntity.map { monsterEntity ->
            MonsterEntity(
                monsterEntity.id,
                monsterEntity.name,
                monsterEntity.category,
                monsterEntity.types,
                monsterEntity.gender,
                monsterEntity.biology,
                monsterEntity.height,
                monsterEntity.weakness,
                monsterEntity.weight,
                monsterEntity.imageUrl,
                monsterEntity.owner,
                monsterEntity.isFavorite
            )
        }

    fun mapEntityToDomain(monsterEntity: MonsterEntity) =
        Monster(
            monsterEntity.id,
            monsterEntity.name,
            monsterEntity.category,
            monsterEntity.types,
            monsterEntity.gender,
            monsterEntity.biology,
            monsterEntity.height,
            monsterEntity.weakness,
            monsterEntity.weight,
            monsterEntity.imageUrl,
            monsterEntity.owner,
            monsterEntity.isFavorite
        )
}