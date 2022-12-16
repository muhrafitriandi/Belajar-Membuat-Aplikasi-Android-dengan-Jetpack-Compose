package com.yandey.pokedex.data.models

import com.google.gson.annotations.SerializedName

data class Monster(

    @field:SerializedName("id")
    val id: Long,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("category")
    val category: String,

    @field:SerializedName("type")
    val type: List<String>,

    @field:SerializedName("gender")
    val gender: String,

    @field:SerializedName("biology")
    val biology: String,

    @field:SerializedName("height")
    val height: String,

    @field:SerializedName("weakness")
    val weakness: String,

    @field:SerializedName("weight")
    val weight: String,

    @field:SerializedName("image_url")
    val imageUrl: String,

    @field:SerializedName("owner")
    val owner: Owner,

    var isFavorite: Boolean = false,
)

data class Owner(

    @field:SerializedName("id")
    val id: Long,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("trainer_class")
    val trainerClass: String,

    @field:SerializedName("image_url")
    val imageUrl: String,
)