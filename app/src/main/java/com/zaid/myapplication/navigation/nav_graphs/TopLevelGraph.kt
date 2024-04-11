package com.zaid.myapplication.navigation.nav_graphs

import androidx.compose.material3.SnackbarDuration
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.zaid.myapplication.feature_main.presentation.add_Item_screen.AddItemScreen
import com.zaid.myapplication.feature_main.presentation.add_Item_screen.AddItemScreenViewModel
import com.zaid.myapplication.feature_main.presentation.all_items_screen.AllItemsScreen
import com.zaid.myapplication.feature_main.presentation.all_items_screen.AllItemsScreenViewModel
import com.zaid.myapplication.navigation.NavGraphRoutes
import com.zaid.myapplication.navigation.Screen

fun NavGraphBuilder.topLevelGraph(
    navController: NavController,
    onShowSnackBar: suspend (message: String, actionLabel: String?, duration: SnackbarDuration) -> Boolean
) {
    navigation(startDestination = Screen.AllItemsScreen.route, route = NavGraphRoutes.TOP_LEVEL) {

        composable(route = Screen.AllItemsScreen.route) {

            val allItemsScreenViewModel: AllItemsScreenViewModel = hiltViewModel()
            val allItemsScreenUiState by allItemsScreenViewModel.allItemsUiState.collectAsStateWithLifecycle()
            AllItemsScreen(
                uiState = allItemsScreenUiState,
                onShowSnackBar = onShowSnackBar,
                onMessageDisplay = { allItemsScreenViewModel.onMessageDisplayed() },
            )
        }

        composable(route = Screen.AddItemScreen.route) {

            val addItemScreenViewModel: AddItemScreenViewModel = hiltViewModel()
            val addItemScreenUiState by addItemScreenViewModel.addItemUiState.collectAsStateWithLifecycle()

            AddItemScreen(
                uiState = addItemScreenUiState,
                onShowSnackBar = onShowSnackBar,
                onMessageDisplay = { addItemScreenViewModel.onMessageDisplayed() },
                addItem = addItemScreenViewModel::addItem
            )
        }

    }
}