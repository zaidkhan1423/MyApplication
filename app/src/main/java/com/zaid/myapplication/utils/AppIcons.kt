package com.zaid.myapplication.utils

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.zaid.myapplication.R

object AppIcons {
    val AllItemsSelectedIcon = R.drawable.selected_all_items
    val AllItemsUnselectedIcon = R.drawable.unselected_all_items
    val AddItemSelectedIcon = R.drawable.selected_add_item
    val AddItemUnselectedIcon = R.drawable.unselected_add_item
}

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}