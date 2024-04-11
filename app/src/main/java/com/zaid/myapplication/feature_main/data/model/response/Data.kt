package com.zaid.myapplication.feature_main.data.model.response

data class Data(
    val catItems: List<CatItem>,
    val catagryName: String,
    val isActive: String,
    val storeName: String,
    val store_cat_id: Int,
    val store_cat_img: String,
    val store_uid: Int,
    val uid: Int
)