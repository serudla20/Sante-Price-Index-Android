package com.example.santepriceindex.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.santepriceindex.Product
import com.google.firebase.database.*

@Composable
fun PriceBoardScreen() {

    val productList = remember {
        mutableStateListOf<Product>()
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
            .background(Color.Black)
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(

            text = "SANTE PRICE BOARD",

            color = Color.Yellow,

            fontSize = 28.sp,

            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        LazyColumn {

            items(productList) { product ->

                ElevatedCard(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),

                    elevation =
                        CardDefaults.elevatedCardElevation(
                            defaultElevation = 6.dp
                        )
                ) {

                    Row(

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),

                        horizontalArrangement =
                            Arrangement.SpaceBetween
                    ) {

                        Text(

                            text = product.productName,

                            fontSize = 22.sp,

                            fontWeight = FontWeight.Bold
                        )

                        Text(

                            text = "₹${product.sellingPrice}",

                            fontSize = 22.sp,

                            color = Color.Green,

                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}