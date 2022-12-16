package com.yandey.pokedex.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yandey.pokedex.data.models.Owner
import com.yandey.pokedex.utils.ConstDB.COL_BIOLOGY
import com.yandey.pokedex.utils.ConstDB.COL_CATEGORY
import com.yandey.pokedex.utils.ConstDB.COL_GENDER
import com.yandey.pokedex.utils.ConstDB.COL_HEIGHT
import com.yandey.pokedex.utils.ConstDB.COL_ID
import com.yandey.pokedex.utils.ConstDB.COL_IMAGE_URL
import com.yandey.pokedex.utils.ConstDB.COL_IS_FAVORITE
import com.yandey.pokedex.utils.ConstDB.COL_NAME
import com.yandey.pokedex.utils.ConstDB.COL_OWNER
import com.yandey.pokedex.utils.ConstDB.COL_TYPES
import com.yandey.pokedex.utils.ConstDB.COL_WEAKNESS
import com.yandey.pokedex.utils.ConstDB.COL_WEIGHT
import com.yandey.pokedex.utils.ConstDB.MONSTER_TABLE

@Entity(tableName = MONSTER_TABLE)
data class MonsterEntity(

    @PrimaryKey(autoGenerate = true)
    @field:ColumnInfo(name = COL_ID)
    val id: Long,

    @field:ColumnInfo(name = COL_NAME)
    val name: String,

    @field:ColumnInfo(name = COL_CATEGORY)
    val category: String,

    @field:ColumnInfo(name = COL_TYPES)
    val types: List<String>,

    @field:ColumnInfo(name = COL_GENDER)
    val gender: String,

    @field:ColumnInfo(name = COL_BIOLOGY)
    val biology: String,

    @field:ColumnInfo(name = COL_HEIGHT)
    val height: String,

    @field:ColumnInfo(name = COL_WEAKNESS)
    val weakness: String,

    @field:ColumnInfo(name = COL_WEIGHT)
    val weight: String,

    @field:ColumnInfo(name = COL_IMAGE_URL)
    val imageUrl: String,

    @field:ColumnInfo(name = COL_OWNER)
    val owner: Owner,

    @field:ColumnInfo(name = COL_IS_FAVORITE)
    var isFavorite: Boolean = false,
)