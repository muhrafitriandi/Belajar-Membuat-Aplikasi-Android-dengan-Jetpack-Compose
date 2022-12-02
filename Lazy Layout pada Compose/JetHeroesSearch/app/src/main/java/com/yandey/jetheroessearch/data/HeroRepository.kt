package com.yandey.jetheroessearch.data

import com.yandey.jetheroessearch.HeroesData
import com.yandey.jetheroessearch.model.Hero

class HeroRepository {
    fun getHeroes(): List<Hero> {
        return HeroesData.heroes
    }

    fun searchHeroes(query: String): List<Hero>{
        return HeroesData.heroes.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}