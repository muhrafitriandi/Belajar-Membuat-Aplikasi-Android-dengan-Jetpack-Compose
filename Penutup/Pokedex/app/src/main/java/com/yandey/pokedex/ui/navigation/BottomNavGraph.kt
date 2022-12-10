package com.yandey.pokedex.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yandey.pokedex.ui.screen.favorite.FavoriteScreen
import com.yandey.pokedex.ui.screen.home.HomeScreen
import com.yandey.pokedex.ui.screen.profile.ProfileScreen

@Composable
fun BottomNavGraph(
    navHostController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navigateToDetail = { id ->
                navHostController.navigate(Screen.DetailMonster.createRoute(id))
            })
        }
        composable(route = Screen.Favorite.route) {
            FavoriteScreen()
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }
    }
}