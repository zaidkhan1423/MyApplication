package com.zaid.myapplication.feature_main.data.model.response

data class GetAllItemsResponse(
    val data: List<Data>,
    val message: String,
    val successful: Boolean
)