package com.yandey.pokedex.ui.navigation

import com.yandey.pokedex.utils.Route.DETAIL_ROUTE
import com.yandey.pokedex.utils.Route.FAVORITE_ROUTE
import com.yandey.pokedex.utils.Route.HOME_ROUTE
import com.yandey.pokedex.utils.Route.PROFILE_ROUTE

@Suppress("unused")
sealed class Screen(val route: String) {
    object Home : Screen(HOME_ROUTE)
    object Favorite : Screen(FAVORITE_ROUTE)
    object Profile : Screen(PROFILE_ROUTE)
    object DetailMonster : Screen(DETAIL_ROUTE) {
        fun createRoute(id: Long) = "$HOME_ROUTE/$id"
    }
}