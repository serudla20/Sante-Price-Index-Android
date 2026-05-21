package com.example.santepriceindex

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.database.*

@Composable
fun ViewProductsScreen(navController: NavHostController) {

    val productList = remember {
        mutableStateListOf<Product>()
    }

    var searchText by remember {
        mutableStateOf("")
    }

    val database = FirebaseDatabase
        .getInstance()
        .getReference("Products")

    LaunchedEffect(Unit) {

        database.addValueEventListener(
            object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {

                    productList.clear()

                    for (productSnapshot in snapshot.children) {

                        val product = productSnapshot
                            .getValue(Product::class.java)

                        if (product != null) {

                            productList.add(product)
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "View Products",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(

            value = searchText,

            onValueChange = {
                searchText = it
            },

            label = {
                Text("Search Product")
            },

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {

            items(

                productList.filter {

                    it.productName.contains(
                        searchText,
                        ignoreCase = true
                    )
                }

            ) { product ->

                ElevatedCard(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),

                    elevation = CardDefaults.elevatedCardElevation(
                        defaultElevation = 6.dp
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = "Product: ${product.productName}"
                        )

                        Spacer(
                            modifier = Modifier.height(5.dp)
                        )

                        Text(
                            text = "Cost Price: ${product.costPrice}"
                        )

                        Spacer(
                            modifier = Modifier.height(5.dp)
                        )

                        Text(
                            text = "Selling Price: ${product.sellingPrice}"
                        )

                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )

                        ElevatedButton(
                            onClick = {

                                navController.navigate(

                                    "edit/${product.id}/${product.productName}/${product.costPrice}/${product.sellingPrice}"
                                )
                            }
                        ) {

                            Text("Edit")
                        }

                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )

                        ElevatedButton(

                            onClick = {

                                database
                                    .child(product.id)
                                    .removeValue()
                            }

                        ) {

                            Text("Delete")
                        }
                    }
                }
            }
        }
    }
}