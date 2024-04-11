package com.zaid.myapplication.core.presentation.my_app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.zaid.myapplication.navigation.Screen
import com.zaid.myapplication.navigation.TopLevelDestination

@Composable
fun rememberMyAppState(
    navController: NavHostController = rememberNavController(),
): MyAppState {
    return remember(
        navController
    ) {
        MyAppState(
            navController
        )
    }
}

class MyAppState(
    val navController: NavHostController,
    ) {

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    val shouldShowBottomBar: Boolean
        @Composable get() = when(currentDestination?.route) {
            Screen.AllItemsScreen.route -> true
            Screen.AddItemScreen.route -> true
            else -> false
        }

}