package com.zaid.myapplication.core.presentation.my_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import com.zaid.myapplication.core.presentation.navigation_bar.MyNavigationBar
import com.zaid.myapplication.core.presentation.navigation_bar.MyNavigationItem
import com.zaid.myapplication.navigation.AppNavHost
import com.zaid.myapplication.navigation.TopLevelDestination
import com.zaid.myapplication.utils.Icon


@Composable
fun MyApp(
    appState: MyAppState = rememberMyAppState()
) {

    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
        bottomBar = {
            if (appState.shouldShowBottomBar) {
                MyBottomBar(
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = { topLevelDestination ->
                        appState.navController.navigate(topLevelDestination.route) {
                            popUpTo(0)
                        }
                    },
                    currentDestination = appState.currentDestination
                )
            }
        }
    ) { paddingValues ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            AppNavHost(navHostController = appState.navController,
                onShowSnackBar = { message, action, duration ->
                    snackBarHostState.showSnackbar(
                        message = message,
                        actionLabel = action,
                        duration = duration,
                        withDismissAction = duration == SnackbarDuration.Indefinite
                    ) == SnackbarResult.ActionPerformed
                }
            )
        }
    }
}

@Composable
private fun MyBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {

    MyNavigationBar(
        modifier = modifier
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination?.route == destination.route

            MyNavigationItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    val icon = if (selected) {
                        destination.selectedIcon
                    } else {
                        destination.unselectedIcon
                    }
                    when (icon) {
                        is Icon.ImageVectorIcon -> Image(
                            imageVector = icon.imageVector,
                            contentDescription = null,
                        )

                        is Icon.DrawableResourceIcon -> Image(
                            painter = painterResource(id = icon.id),
                            contentDescription = null,
                        )
                    }
                }
            )
        }
    }
}