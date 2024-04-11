package com.zaid.myapplication.navigation

import androidx.compose.material3.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.zaid.myapplication.navigation.nav_graphs.authGraph
import com.zaid.myapplication.navigation.nav_graphs.topLevelGraph

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    onShowSnackBar: suspend (message: String, actionLabel: String?, duration: SnackbarDuration) -> Boolean,
    ) {
    NavHost(navController = navHostController, startDestination = NavGraphRoutes.AUTH) {
        authGraph(navController = navHostController)
        topLevelGraph(navController = navHostController, onShowSnackBar = onShowSnackBar)
    }
}

object NavGraphRoutes {
    const val AUTH = "auth_route"
    const val TOP_LEVEL = "top_level_route"
}