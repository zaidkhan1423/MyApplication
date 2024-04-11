package com.zaid.myapplication.feature_main.presentation.all_items_screen

import com.zaid.myapplication.feature_main.presentation.model.GetAllItemsResponseLocal

data class AllItemsUiState(
    val loading: Boolean = false,
    val shouldNavigate: Boolean = false,
    val snackBarMessage: String? = null,
    val allItemsResponse: GetAllItemsResponseLocal = GetAllItemsResponseLocal(
        data = emptyList(),
        message = "",
        successful = false
    )
)
