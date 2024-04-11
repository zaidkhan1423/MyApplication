package com.zaid.myapplication.navigation

import com.zaid.myapplication.utils.AppIcons
import com.zaid.myapplication.utils.Icon


enum class TopLevelDestination(
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val route: String
) {

    ALL_ITEMS_SCREEN(
        selectedIcon = Icon.DrawableResourceIcon(AppIcons.AllItemsSelectedIcon),
        unselectedIcon = Icon.DrawableResourceIcon(AppIcons.AllItemsUnselectedIcon),
        route = Screen.AllItemsScreen.route
    ),
    ADD_ITEM_SCREEN(
        selectedIcon = Icon.DrawableResourceIcon(AppIcons.AddItemSelectedIcon),
        unselectedIcon = Icon.DrawableResourceIcon(AppIcons.AddItemUnselectedIcon),
        route = Screen.AddItemScreen.route
    )

}