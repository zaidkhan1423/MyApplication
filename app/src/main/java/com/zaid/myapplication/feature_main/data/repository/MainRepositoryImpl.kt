package com.zaid.myapplication.feature_main.data.repository

import com.zaid.myapplication.feature_main.data.MainApiService
import com.zaid.myapplication.feature_main.data.model.request.AddItemRequest
import com.zaid.myapplication.feature_main.data.model.request.GetAllItemsRequest
import com.zaid.myapplication.feature_main.data.model.request.ItemImage
import com.zaid.myapplication.feature_main.data.model.response.AddItemResponse
import com.zaid.myapplication.feature_main.data.model.response.GetAllItemsResponse
import com.zaid.myapplication.feature_main.domain.MainRepository
import retrofit2.Response
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val apiService: MainApiService
) : MainRepository {
    override suspend fun getAllItems(): Response<GetAllItemsResponse> = apiService.getAllItems(
        GetAllItemsRequest()
    )

    override suspend fun addItem(
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
    ): Response<AddItemResponse> = apiService.insertItem(
        request = AddItemRequest(
            buying_price = buying_price,
            isNewArrival = isNewArrival,
            item_MRP = item_MRP,
            item_description = item_description,
            item_image = listOf(
                ItemImage(
                    image_id = 0,
                    image_url = "",
                    item_Id = 0,
                    sno = 0
                )
            ),
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
    )
}