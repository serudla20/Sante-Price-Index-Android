package com.example.santepriceindex.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.santepriceindex.Product
import com.google.firebase.database.FirebaseDatabase

@Composable
fun EditProductScreen(

    navController: NavHostController,

    product: Product
) {

    var productName by remember {
        mutableStateOf(product.productName)
    }

    var costPrice by remember {
        mutableStateOf(product.costPrice)
    }

    var sellingPrice by remember {
        mutableStateOf(product.sellingPrice)
    }

    val database = FirebaseDatabase
        .getInstance()
        .getReference("Products")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Edit Product",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productName,
            onValueChange = {
                productName = it
            },
            label = {
                Text("Product Name")
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = costPrice,
            onValueChange = {
                costPrice = it
            },
            label = {
                Text("Cost Price")
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = sellingPrice,
            onValueChange = {
                sellingPrice = it
            },
            label = {
                Text("Selling Price")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                val updatedProduct = Product(
                    product.id,
                    productName,
                    costPrice,
                    sellingPrice
                )

                database
                    .child(product.id)
                    .setValue(updatedProduct)

                navController.popBackStack()
            }
        ) {

            Text("Update Product")
        }
    }
}