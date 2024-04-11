package com.zaid.myapplication.feature_main.presentation.model

import com.zaid.myapplication.feature_main.data.model.response.CatItem
import com.zaid.myapplication.feature_main.data.model.response.Data
import com.zaid.myapplication.feature_main.data.model.response.GetAllItemsResponse
import com.zaid.myapplication.feature_main.data.model.response.ItemImage

// Local versions of your data classes
data class CatItemLocal(
    val addedOn: String,
    val buyingPrice: Double,
    val isNewArrival: String,
    val isOutOfStock: String,
    val isActive: String,
    val itemMRP: Double,
    val itemDescription: String,
    val itemImages: List<ItemImageLocal>,
    val itemWeight: Double,
    val itemWeightUnit: String,
    val minimumQtyBuy: Int,
    val minimumQtyUnit: String,
    val sellingPrice: Double,
    val storeCatId: Int,
    val storeItemName: String,
    val storeUid: Int,
    val uid: Int
)

data class DataLocal(
    val catItems: List<CatItemLocal>,
    val categoryName: String,
    val isActive: String,
    val storeName: String,
    val storeCatId: Int,
    val storeCatImg: String,
    val storeUid: Int,
    val uid: Int
)

data class ItemImageLocal(
    val imageId: Int,
    val imageUrl: String,
    val itemId: Int,
    val sno: Int
)

data class GetAllItemsResponseLocal(
    val data: List<DataLocal>,
    val message: String,
    val successful: Boolean
)

fun GetAllItemsResponse.toLocal(): GetAllItemsResponseLocal {
    return GetAllItemsResponseLocal(
        data = data.map { it.toLocal() },
        message = message,
        successful = successful
    )
}

// Extension functions to convert to local models
fun CatItem.toLocal(): CatItemLocal {
    return CatItemLocal(
        addedOn = added_on,
        buyingPrice = buying_price,
        isNewArrival = isNewArrival,
        isOutOfStock = isOutOfStock,
        isActive = isactive,
        itemMRP = item_MRP,
        itemDescription = item_description,
        itemImages = item_image.map { it.toLocal() },
        itemWeight = item_weight,
        itemWeightUnit = item_weight_unit,
        minimumQtyBuy = minimun_Qty_Buy,
        minimumQtyUnit = minimun_Qty_Unit,
        sellingPrice = selling_price,
        storeCatId = store_cat_id,
        storeItemName = store_item_Name,
        storeUid = store_uid,
        uid = uid
    )
}

fun Data.toLocal(): DataLocal {
    return DataLocal(
        catItems = catItems.map { it.toLocal() },
        categoryName = catagryName,
        isActive = isActive,
        storeName = storeName,
        storeCatId = store_cat_id,
        storeCatImg = store_cat_img,
        storeUid = store_uid,
        uid = uid
    )
}

fun ItemImage.toLocal(): ItemImageLocal {
    return ItemImageLocal(
        imageId = image_id,
        imageUrl = image_url,
        itemId = item_Id,
        sno = sno
    )
}
