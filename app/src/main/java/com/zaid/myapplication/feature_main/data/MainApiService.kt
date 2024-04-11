package com.zaid.myapplication.feature_main.data

import com.zaid.myapplication.feature_main.data.model.request.AddItemRequest
import com.zaid.myapplication.feature_main.data.model.request.GetAllItemsRequest
import com.zaid.myapplication.feature_main.data.model.response.AddItemResponse
import com.zaid.myapplication.feature_main.data.model.response.GetAllItemsResponse
import com.zaid.myapplication.utils.Endpoints.GET_STORE_ITEMS
import com.zaid.myapplication.utils.Endpoints.INSERT_STORE_ITEM
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MainApiService {

    @POST(GET_STORE_ITEMS)
    suspend fun getAllItems(@Body request: GetAllItemsRequest): Response<GetAllItemsResponse>

    @POST(INSERT_STORE_ITEM)
    suspend fun insertItem(@Body request: AddItemRequest): Response<AddItemResponse>

}