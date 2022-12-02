package com.yandey.jetheroessearch.data

import com.yandey.jetheroessearch.HeroesData
import com.yandey.jetheroessearch.model.Hero

class HeroRepository {
    fun getHeroes(): List<Hero> {
        return HeroesData.heroes
    }
}