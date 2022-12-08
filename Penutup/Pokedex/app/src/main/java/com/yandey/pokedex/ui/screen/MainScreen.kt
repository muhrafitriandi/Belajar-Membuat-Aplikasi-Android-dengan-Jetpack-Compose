package com.yandey.pokedex.ui.screen

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yandey.pokedex.R
import com.yandey.pokedex.ui.navigation.BottomNavGraph
import com.yandey.pokedex.ui.navigation.NavigationItem
import com.yandey.pokedex.ui.navigation.Screen
import com.yandey.pokedex.ui.theme.PokedexTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            BottomBar(
                navHostController = navHostController
            )
        },
        modifier = modifier
    ) { paddingValues ->
        BottomNavGraph(
            navHostController = navHostController,
            paddingValues = paddingValues
        )
    }
}

@Composable
fun BottomBar(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        modifier = modifier
    ) {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_favorite),
                icon = Icons.Default.Favorite,
                screen = Screen.Favorite
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_profile),
                icon = Icons.Default.AccountCircle,
                screen = Screen.Profile
            )
        )
        BottomNavigation {
            navigationItems.map { navigationItem ->
                AddItem(
                    navigationItem = navigationItem,
                    currentRoute = currentRoute,
                    navHostController = navHostController
                )
            }
        }
    }
}

@Composable
private fun RowScope.AddItem(
    navigationItem: NavigationItem,
    currentRoute: NavDestination?,
    navHostController: NavHostController
) {
    BottomNavigationItem(
        icon = {
            Icon(
                imageVector = navigationItem.icon,
                contentDescription = navigationItem.title
            )
        },
        label = {
            Text(
                text = navigationItem.title
            )
        },
        selected = currentRoute?.hierarchy?.any { navDestination ->
            navDestination.route == navigationItem.screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navHostController.navigate(route = navigationItem.screen.route) {
                popUpTo(id = navHostController.graph.findStartDestination().id) {
                    saveState = true
                }
                restoreState = true
                launchSingleTop = true
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    PokedexTheme {
        MainScreen()
    }
}