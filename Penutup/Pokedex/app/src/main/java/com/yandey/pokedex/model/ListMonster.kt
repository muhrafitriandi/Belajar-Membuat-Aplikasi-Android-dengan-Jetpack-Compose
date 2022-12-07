package com.yandey.pokedex.model

import com.google.gson.annotations.SerializedName

data class ListMonster(

	@field:SerializedName("total_count")
	val totalCount: Int,

	@field:SerializedName("monsters")
	val monsters: List<Monster>
)

data class Owner(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("trainer_class")
	val trainerClass: String,

	@field:SerializedName("image_url")
	val imageUrl: String
)

data class Monster(

	@field:SerializedName("id")
	val id: Int,

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
	val owner: Owner
)
