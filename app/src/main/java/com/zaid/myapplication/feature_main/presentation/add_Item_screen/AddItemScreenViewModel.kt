package com.zaid.myapplication.feature_main.presentation.add_Item_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaid.myapplication.feature_main.domain.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddItemScreenViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _addItemUiState = MutableStateFlow(AddItemUiState())
    val addItemUiState = _addItemUiState.asStateFlow()

    fun onMessageDisplayed() {
        _addItemUiState.update {
            it.copy(
                snackBarMessage = null
            )
        }
    }

    fun addItem(
        buying_price: Int,
        isNewArrival: String,
        item_MRP: Int,
        item_description: String,
//        item_image: List<ItemImage>,
        item_weight: Int,
        item_weight_unit: String,
        minimun_Qty_Buy: Int,
        minimun_Qty_Unit: String,
        selling_price: Int,
        store_cat_id: Int,
        store_item_Name: String,
        store_uid: Int,
        uid: Int
    ) = viewModelScope.launch(Dispatchers.IO) {
        _addItemUiState.update {
            it.copy(
                loading = true,
                snackBarMessage = null
            )
        }

        try {
            val response = repository.addItem(
                buying_price = buying_price,
                isNewArrival = isNewArrival,
                item_MRP = item_MRP,
                item_description = item_description,
//                item_image = item_image,
                item_weight = item_weight,
                item_weight_unit = item_weight_unit,
                minimun_Qty_Buy = minimun_Qty_Buy,
                minimun_Qty_Unit = minimun_Qty_Unit,
                selling_price = selling_price,
                store_cat_id = store_cat_id,
                store_item_Name = store_item_Name,
                store_uid = store_uid,
                uid = uid
            )

            if (response.isSuccessful || response.body() != null) {
                Log.d("AddItemVM", "Success ${response.body()}")
                _addItemUiState.update { uiState ->
                    uiState.copy(
                        loading = false,
                        snackBarMessage = response.body()!!.message
                    )
                }
            } else {
                _addItemUiState.update { uiState ->
                    Log.d("AddItemVM", "Error Code:${response.code()} Message:${response.message()}")
                    uiState.copy(
                        loading = false, snackBarMessage = response.message()
                    )
                }
            }
        } catch (e: Exception) {
            _addItemUiState.update { uiState ->
                Log.d("AddItemVM", "Error ${e.message}")
                uiState.copy(
                    loading = false, snackBarMessage = e.message
                )
            }
        }
    }
}