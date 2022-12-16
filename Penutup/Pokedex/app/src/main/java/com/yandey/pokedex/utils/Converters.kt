package com.yandey.pokedex.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.yandey.pokedex.data.models.Owner

class Converters {
    @TypeConverter
    fun fromListStringToString(value: List<String>): String = Gson().toJson(value)

    @TypeConverter
    fun fromStringToListString(value: String): List<String> =
        Gson().fromJson(value, Array<String>::class.java).toList()

    @TypeConverter
    fun fromOwnerToName(owner: Owner): String {
        return Gson().toJson(owner)
    }

    @TypeConverter
    fun fromStringToOwner(value: String): Owner {
        return Gson().fromJson(value, Owner::class.java)
    }
}