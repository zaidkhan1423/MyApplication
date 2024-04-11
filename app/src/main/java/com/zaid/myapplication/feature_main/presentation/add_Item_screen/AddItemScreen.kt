package com.zaid.myapplication.feature_main.presentation.add_Item_screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddItemScreen(
    uiState: AddItemUiState,
    onMessageDisplay: () -> Unit,
    onShowSnackBar: suspend (message: String, actionLabel: String?, duration: SnackbarDuration) -> Boolean,
    addItem: (
        buying_price: Int,
        isNewArrival: String,
        item_MRP: Int,
        item_description: String,
        item_weight: Int,
        item_weight_unit: String,
        minimun_Qty_Buy: Int,
        minimun_Qty_Unit: String,
        selling_price: Int,
        store_cat_id: Int,
        store_item_Name: String,
        store_uid: Int,
        uid: Int
    ) -> Unit
) {

    LaunchedEffect(key1 = uiState) {
        if (uiState.snackBarMessage != null) {
            onShowSnackBar(uiState.snackBarMessage, null, SnackbarDuration.Short)
            onMessageDisplay()
        }
    }

    var storeName by remember {
        mutableStateOf("")
    }
    var itemMrp by remember {
        mutableStateOf("")
    }
    var itemWeight by remember {
        mutableStateOf("")
    }
    var sellingPrice by remember {
        mutableStateOf("")
    }
    var buyingPrice by remember {
        mutableStateOf("")
    }
    var itemDescription by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(20.dp))

        Text(text = "Add Your Item", fontSize = 18.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.size(20.dp))

        OutlinedTextField(
            value = storeName,
            onValueChange = { storeName = it },
            singleLine = true,
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            placeholder = {
                Text(
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    text = "Store Name"
                )
            },
            modifier = Modifier
                .widthIn(500.dp)
                .padding(horizontal = 28.dp)
        )

        Spacer(modifier = Modifier.size(20.dp))

        OutlinedTextField(
            value = itemMrp,
            onValueChange = { itemMrp = it },
            singleLine = true,
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            placeholder = {
                Text(
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    text = "Item's MRP"
                )
            },
            modifier = Modifier
                .widthIn(500.dp)
                .padding(horizontal = 28.dp)
        )

        Spacer(modifier = Modifier.size(20.dp))

        OutlinedTextField(
            value = itemWeight,
            onValueChange = { itemWeight = it },
            singleLine = true,
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            placeholder = {
                Text(
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    text = "Item Weight"
                )
            },
            modifier = Modifier
                .widthIn(500.dp)
                .padding(horizontal = 28.dp)
        )

        Spacer(modifier = Modifier.size(20.dp))

        OutlinedTextField(
            value = sellingPrice,
            onValueChange = { sellingPrice = it },
            singleLine = true,
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            placeholder = {
                Text(
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    text = "Selling Price"
                )
            },
            modifier = Modifier
                .widthIn(500.dp)
                .padding(horizontal = 28.dp)
        )

        Spacer(modifier = Modifier.size(20.dp))

        OutlinedTextField(
            value = buyingPrice,
            onValueChange = { buyingPrice = it },
            singleLine = true,
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            placeholder = {
                Text(
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    text = "Buying Price"
                )
            },
            modifier = Modifier
                .widthIn(500.dp)
                .padding(horizontal = 28.dp)
        )

        Spacer(modifier = Modifier.size(20.dp))

        OutlinedTextField(
            value = itemDescription,
            onValueChange = { itemDescription = it },
            singleLine = true,
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            placeholder = {
                Text(
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    text = "Item Description"
                )
            },
            modifier = Modifier
                .widthIn(500.dp)
                .padding(horizontal = 28.dp)
        )

        Spacer(modifier = Modifier.size(20.dp))

        Box(
            modifier = Modifier
                .widthIn(500.dp)
                .padding(horizontal = 28.dp)
        ) {
            Button(
                onClick = {
                    if (buyingPrice == "" && itemMrp == "" && itemDescription == "" && sellingPrice == "" && storeName == "" && itemWeight == "") {
                        Toast.makeText(context, "Fill All Fields", Toast.LENGTH_SHORT).show()
                    } else {
                        addItem(
                            buyingPrice.toInt(),
                            "Y",
                            itemMrp.toInt(),
                            itemDescription,
                            itemWeight.toInt(),
                            "KG",
                            0,
                            "KG",
                            sellingPrice.toInt(),
                            1,
                            storeName,
                            180,
                            89
                        )
                    }
                },
                modifier = Modifier
                    .widthIn(150.dp)
                    .height(48.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Add Item", fontSize = MaterialTheme.typography.bodyLarge.fontSize)
            }
        }

    }

}


@Preview(showBackground = true)
@Composable
fun AddItemScreenPreview() {
    AddItemScreen(
        uiState = AddItemUiState(),
        onMessageDisplay = {},
        onShowSnackBar = { _, _, _ -> false },
        addItem = { _, _, _, _, _, _, _, _, _, _, _, _, _ -> }
    )
}