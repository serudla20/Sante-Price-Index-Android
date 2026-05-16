package com.example.santepriceindex.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorScreen() {

    var mandiPrice by remember {
        mutableStateOf("")
    }

    var transportCost by remember {
        mutableStateOf("")
    }

    var profitMargin by remember {
        mutableStateOf("")
    }

    var result by remember {
        mutableStateOf(0.0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Profit Calculator",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = mandiPrice,
            onValueChange = {
                mandiPrice = it
            },
            label = {
                Text("Mandi Price")
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = transportCost,
            onValueChange = {
                transportCost = it
            },
            label = {
                Text("Transport Cost")
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = profitMargin,
            onValueChange = {
                profitMargin = it
            },
            label = {
                Text("Profit Margin")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                val mandi =
                    mandiPrice.toDoubleOrNull() ?: 0.0

                val transport =
                    transportCost.toDoubleOrNull() ?: 0.0

                val profit =
                    profitMargin.toDoubleOrNull() ?: 0.0

                result =
                    mandi + transport + profit
            }
        ) {

            Text("Calculate")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Recommended Price: ₹$result",
            style = MaterialTheme.typography.headlineSmall
        )
    }
}