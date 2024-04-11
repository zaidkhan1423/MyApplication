package com.zaid.myapplication.feature_main.data.model.response

data class CatItem(
    val added_on: String,
    val buying_price: Double,
    val isNewArrival: String,
    val isOutOfStock: String,
    val isactive: String,
    val item_MRP: Double,
    val item_description: String,
    val item_image: List<ItemImage>,
    val item_weight: Double,
    val item_weight_unit: String,
    val minimun_Qty_Buy: Int,
    val minimun_Qty_Unit: String,
    val selling_price: Double,
    val store_cat_id: Int,
    val store_item_Name: String,
    val store_uid: Int,
    val uid: Int
)