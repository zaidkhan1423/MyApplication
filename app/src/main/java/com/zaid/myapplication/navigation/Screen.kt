package com.zaid.myapplication.navigation

sealed class Screen(val route: String) {

    object LoginScreen : Screen("login_screen")
    object SignUpScreen : Screen("signup_screen")

    object AddItemScreen : Screen("add_item_screen")
    object AllItemsScreen : Screen("all_items_screen")

}