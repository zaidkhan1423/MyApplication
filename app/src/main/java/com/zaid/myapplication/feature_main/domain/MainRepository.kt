package com.zaid.myapplication.feature_main.domain

import com.zaid.myapplication.feature_main.data.model.response.AddItemResponse
import com.zaid.myapplication.feature_main.data.model.response.GetAllItemsResponse
import retrofit2.Response

interface MainRepository {

    suspend fun getAllItems(): Response<GetAllItemsResponse>

    suspend fun addItem(
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
    ): Response<AddItemResponse>

}