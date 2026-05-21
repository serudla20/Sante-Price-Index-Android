package com.example.santepriceindex.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CalculatorScreen(navController: NavHostController) {

    var costPrice by remember {
        mutableStateOf("")
    }

    var transportCost by remember {
        mutableStateOf("")
    }

    var extraCharges by remember {
        mutableStateOf("")
    }

    var profitPercent by remember {
        mutableStateOf("")
    }

    var result by remember {
        mutableStateOf("")
    }

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
            onValueChange = {
                costPrice = it
            },
            label = {
                Text("Cost Price")
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
            value = extraCharges,
            onValueChange = {
                extraCharges = it
            },
            label = {
                Text("Extra Charges")
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = profitPercent,
            onValueChange = {
                profitPercent = it
            },
            label = {
                Text("Desired Profit %")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(

            onClick = {

                if (
                    costPrice.isEmpty() ||
                    transportCost.isEmpty() ||
                    extraCharges.isEmpty() ||
                    profitPercent.isEmpty()
                ) {

                    result = "Please fill all fields"

                } else {

                    val cp = costPrice.toDoubleOrNull() ?: 0.0
                    val tc = transportCost.toDoubleOrNull() ?: 0.0
                    val ec = extraCharges.toDoubleOrNull() ?: 0.0
                    val pp = profitPercent.toDoubleOrNull() ?: 0.0

                    if (
                        cp < 0 ||
                        tc < 0 ||
                        ec < 0 ||
                        pp < 0
                    ) {

                        result = "Invalid values"

                    } else {

                        val totalCost = cp + tc + ec

                        val profitAmount =
                            (totalCost * pp) / 100

                        val sellingPrice =
                            totalCost + profitAmount

                        result =
                            "Suggested Selling Price: ₹$sellingPrice"
                    }
                }
            }

        ) {

            Text("Calculate")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = result,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}