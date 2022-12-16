package com.yandey.pokedex.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yandey.pokedex.data.local.entity.MonsterEntity
import com.yandey.pokedex.utils.ConstDB.COL_ID
import com.yandey.pokedex.utils.ConstDB.COL_IS_FAVORITE
import com.yandey.pokedex.utils.ConstDB.COL_NAME
import com.yandey.pokedex.utils.ConstDB.MONSTER_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface MonsterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMonsters(listMonsterEntity: List<MonsterEntity>)

    @Query("SELECT * FROM $MONSTER_TABLE ORDER BY $COL_ID ASC")
    fun getAllMonsters(): Flow<List<MonsterEntity>>

    @Query("SELECT * FROM $MONSTER_TABLE WHERE $COL_IS_FAVORITE = 1")
    fun getAllFavoriteMonsters(): Flow<List<MonsterEntity>>

    @Query("SELECT * FROM $MONSTER_TABLE WHERE $COL_ID = :id")
    fun getFavoriteStateMonster(id: Long): Flow<MonsterEntity>

    @Query("SELECT * FROM $MONSTER_TABLE WHERE $COL_NAME LIKE '%'||:name||'%'")
    fun searchMonsters(name: String): Flow<List<MonsterEntity>>

    @Query("UPDATE $MONSTER_TABLE SET $COL_IS_FAVORITE = :isFavorite WHERE $COL_ID = :id")
    suspend fun updateFavoriteMonster(id: Long, isFavorite: Boolean)
}