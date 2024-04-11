package com.zaid.myapplication.feature_main.presentation.all_items_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaid.myapplication.feature_main.domain.MainRepository
import com.zaid.myapplication.feature_main.presentation.model.toLocal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllItemsScreenViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _allItemsUiState = MutableStateFlow(AllItemsUiState())
    val allItemsUiState = _allItemsUiState.asStateFlow()

    init {
        getAllItems()
    }

    fun onMessageDisplayed() {
        _allItemsUiState.update {
            it.copy(
                snackBarMessage = null
            )
        }
    }

    private fun getAllItems() = viewModelScope.launch(Dispatchers.IO) {
        _allItemsUiState.update {
            it.copy(
                loading = true,
                snackBarMessage = null
            )
        }

        try {
            val response = repository.getAllItems()

            if (response.isSuccessful || response.body() != null) {
                Log.d("AllItemVM", "Success ${response.body()}")
                _allItemsUiState.update { uiState ->
                    uiState.copy(
                        loading = false,
                        allItemsResponse = response.body()!!.toLocal(),
                        snackBarMessage = "Data Fetch Successfully"
                    )
                }
            } else {
                _allItemsUiState.update { uiState ->
                    Log.d("AllItemVM", "Error Code:${response.code()} Message:${response.message()}")
                    uiState.copy(
                        loading = false, snackBarMessage = response.message()
                    )
                }
            }
        } catch (e: Exception) {
            _allItemsUiState.update { uiState ->
                Log.d("AllItemVM", "Error ${e.message}")
                uiState.copy(
                    loading = false, snackBarMessage = e.message
                )
            }
        }
    }
}