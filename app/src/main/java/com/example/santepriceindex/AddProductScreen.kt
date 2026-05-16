package com.example.santepriceindex

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.database.FirebaseDatabase

@Composable
fun AddProductScreen(navController: NavHostController) {

    var productName by remember { mutableStateOf("") }
    var costPrice by remember { mutableStateOf("") }
    var sellingPrice by remember { mutableStateOf("") }

    val context = LocalContext.current

    val database = FirebaseDatabase.getInstance()
        .getReference("Products")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Add Product",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text("Product Name") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = costPrice,
            onValueChange = { costPrice = it },
            label = { Text("Cost Price") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = sellingPrice,
            onValueChange = { sellingPrice = it },
            label = { Text("Selling Price") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                if (
                    productName.isNotEmpty() &&
                    costPrice.isNotEmpty() &&
                    sellingPrice.isNotEmpty()
                ) {

                    val productId = database.push().key!!

                    val product = Product(
                        productName,
                        costPrice,
                        sellingPrice
                    )

                    database.child(productId)
                        .setValue(product)
                        .addOnSuccessListener {

                            Toast.makeText(
                                context,
                                "Product Saved",
                                Toast.LENGTH_SHORT
                            ).show()

                            productName = ""
                            costPrice = ""
                            sellingPrice = ""
                        }

                        .addOnFailureListener {

                            Toast.makeText(
                                context,
                                "Failed to Save",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                } else {

                    Toast.makeText(
                        context,
                        "Enter all fields",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        ) {

            Text("Save Product")
        }
    }
}