package com.yandey.jetheroesstickyheader.data

import com.yandey.jetheroesstickyheader.HeroesData
import com.yandey.jetheroesstickyheader.model.Hero

class HeroRepository {
    fun getHeroes(): List<Hero> {
        return HeroesData.heroes
    }
}