package com.zaid.myapplication.feature_main.data.model.request

data class AddItemRequest(
    val buying_price: Int,
    val isNewArrival: String,
    val item_MRP: Int,
    val item_description: String,
    val item_image: List<ItemImage>,
    val item_weight: Int,
    val item_weight_unit: String,
    val minimun_Qty_Buy: Int,
    val minimun_Qty_Unit: String,
    val selling_price: Int,
    val store_cat_id: Int,
    val store_item_Name: String,
    val store_uid: Int,
    val uid: Int
)