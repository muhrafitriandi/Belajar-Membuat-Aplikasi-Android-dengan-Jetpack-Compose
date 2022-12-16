package com.yandey.pokedex.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.yandey.pokedex.ui.screen.detail.DetailScreen
import com.yandey.pokedex.ui.screen.favorite.FavoriteScreen
import com.yandey.pokedex.ui.screen.home.HomeScreen
import com.yandey.pokedex.ui.screen.profile.ProfileScreen
import com.yandey.pokedex.utils.Constant.ID

@Composable
fun BottomNavGraph(
    modifier: Modifier,
    navHostController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route,
        modifier = modifier.padding(paddingValues)
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navigateToDetail = { id ->
                navHostController.navigate(Screen.DetailMonster.createRoute(id))
            })
        }
        composable(route = Screen.Favorite.route) {
            FavoriteScreen(
                navigateToDetail = { id ->
                    navHostController.navigate(Screen.DetailMonster.createRoute(id))
                }
            )
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }
        composable(
            route = Screen.DetailMonster.route,
            arguments = listOf(navArgument(ID) {
                type = NavType.LongType
            })
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getLong(ID) ?: -1L
            DetailScreen(
                id = id,
                navigateBack = { navHostController.navigateUp() }
            )
        }
    }
}