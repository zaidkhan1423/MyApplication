package com.zaid.myapplication.feature_main.presentation.all_items_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun AllItemsScreen(
    uiState: AllItemsUiState,
    onMessageDisplay: () -> Unit,
    onShowSnackBar: suspend (message: String, actionLabel: String?, duration: SnackbarDuration) -> Boolean
) {
    LaunchedEffect(key1 = uiState) {
        if (uiState.snackBarMessage != null) {
            onShowSnackBar(uiState.snackBarMessage, null, SnackbarDuration.Short)
            onMessageDisplay()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background), contentAlignment = Alignment.Center
    ) {

        if (!uiState.allItemsResponse.successful) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary,
                strokeWidth = 4.dp
            )
        } else {

            val allItems by remember {
                mutableStateOf(uiState.allItemsResponse.data)
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 180.dp, max = 1000.dp),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {

                items(allItems.size) { allItemIndex ->

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                            .background(
                                color = MaterialTheme.colorScheme.surface,
                            )
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Store Name: ", fontSize = 14.sp)
                            Text(
                                text = allItems[allItemIndex].storeName,
                                fontSize = 14.sp,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Category Name: ", fontSize = 12.sp)
                            Text(text = allItems[allItemIndex].categoryName, fontSize = 12.sp)
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Is Active: ", fontSize = 12.sp)
                            Text(
                                text = if (allItems[allItemIndex].isActive == "Y") "Yes" else "No",
                                fontSize = 12.sp
                            )
                        }
                    }

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        contentPadding = PaddingValues(
                            vertical = 8.dp
                        ),
                        modifier = Modifier.wrapContentSize()
                    ) {

                        items(allItems[allItemIndex].catItems.size) { catIndex ->
                            Spacer(modifier = Modifier.size(10.dp))
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .width(292.dp)
                                    .wrapContentHeight()
                                    .shadow(
                                        elevation = 8.dp
                                    )
                                    .background(
                                        color = MaterialTheme.colorScheme.surface,
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .clip(RoundedCornerShape(10.dp))
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(), horizontalArrangement = Arrangement.Center

                                ) {

                                    Column(
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(top = 5.dp, start = 10.dp),
                                        verticalArrangement = Arrangement.Center
                                    ) {

                                        Row(
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(text = "Item Name: ", fontSize = 12.sp)
                                            Text(
                                                text = allItems[allItemIndex].catItems[catIndex].storeItemName,
                                                fontSize = 12.sp
                                            )
                                        }

                                        Row(
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(text = "MRP: ", fontSize = 12.sp)
                                            Text(
                                                text = allItems[allItemIndex].catItems[catIndex].itemMRP.toString(),
                                                fontSize = 12.sp
                                            )
                                        }
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(text = "Selling Price: ", fontSize = 12.sp)
                                            Text(
                                                text = allItems[allItemIndex].catItems[catIndex].sellingPrice.toString(),
                                                fontSize = 12.sp
                                            )
                                        }
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(text = "Buying Price: ", fontSize = 12.sp)
                                            Text(
                                                text = allItems[allItemIndex].catItems[catIndex].buyingPrice.toString(),
                                                fontSize = 12.sp
                                            )
                                        }
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(text = "Item Weight: ", fontSize = 12.sp)
                                            Text(
                                                text = "${allItems[allItemIndex].catItems[catIndex].itemWeight} ${allItems[allItemIndex].catItems[catIndex].itemWeightUnit}",
                                                fontSize = 12.sp
                                            )
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .width(80.dp)
                                            .height(99.dp),
                                        contentAlignment = Alignment.CenterEnd
                                    ) {
                                        AsyncImage(
                                            modifier = Modifier
                                                .padding(end = 8.dp)
                                                .size(80.dp)
                                                .clip(RoundedCornerShape(10.dp)),
                                            model = allItems[allItemIndex].catItems[catIndex].itemImages[0].imageUrl,
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.size(5.dp))
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AllItemsScreenPreview() {
    AllItemsScreen(
        uiState = AllItemsUiState(),
        onMessageDisplay = {},
        onShowSnackBar = { _, _, _ -> false }
    )
}