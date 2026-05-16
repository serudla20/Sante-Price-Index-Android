package com.example.santepriceindex.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CalculatorScreen(navController: NavController) {

    var costPrice by remember { mutableStateOf("") }
    var sellingPrice by remember { mutableStateOf("") }

    var profit by remember { mutableStateOf(0.0) }
    var profitPercentage by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Profit Calculator",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

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

                val cp = costPrice.toDoubleOrNull() ?: 0.0
                val sp = sellingPrice.toDoubleOrNull() ?: 0.0

                profit = sp - cp

                profitPercentage =
                    if (cp != 0.0) {
                        (profit / cp) * 100
                    } else {
                        0.0
                    }
            }
        ) {

            Text("Calculate")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Profit Amount: ₹$profit"
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Profit Percentage: ${profitPercentage}%"
        )
    }
}