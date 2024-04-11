package com.zaid.myapplication.navigation.nav_graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.zaid.myapplication.feature_auth.presentation.LoginScreen
import com.zaid.myapplication.feature_auth.presentation.SignUpScreen
import com.zaid.myapplication.navigation.NavGraphRoutes
import com.zaid.myapplication.navigation.Screen

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation(startDestination = Screen.LoginScreen.route, route = NavGraphRoutes.AUTH) {

        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(route = Screen.SignUpScreen.route) {
            SignUpScreen(navController = navController)
        }

    }
}