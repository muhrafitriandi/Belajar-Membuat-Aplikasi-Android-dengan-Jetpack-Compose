package com.yandey.pokedex.model

import com.google.gson.annotations.SerializedName

data class ListMonster(

	@field:SerializedName("total_count")
	val totalCount: Int,

	@field:SerializedName("monsters")
	val monsters: List<Monster>
)

data class Owner(

	@field:SerializedName("trainer_class")
	val trainerClass: String,

	@field:SerializedName("image_url")
	val imageUrl: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)

data class Monster(

	@field:SerializedName("owner")
	val owner: Owner,

	@field:SerializedName("weakness")
	val weakness: String,

	@field:SerializedName("biology")
	val biology: String,

	@field:SerializedName("gender")
	val gender: String,

	@field:SerializedName("image_url")
	val imageUrl: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("weight")
	val weight: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("category")
	val category: String,

	@field:SerializedName("type")
	val type: List<String>,

	@field:SerializedName("height")
	val height: String
)
