package com.yandey.pokedex.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yandey.pokedex.data.local.entity.MonsterEntity
import com.yandey.pokedex.utils.Converters

@Database(entities = [MonsterEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class PokedexDatabase : RoomDatabase() {

    abstract fun monsterDao(): MonsterDao
}