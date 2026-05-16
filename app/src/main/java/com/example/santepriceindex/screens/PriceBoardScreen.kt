package com.example.santepriceindex.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PriceBoardScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "TODAY PRICES",
            color = Color.Yellow,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Tomato ₹40/kg",
            color = Color.Yellow,
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Onion ₹35/kg",
            color = Color.Yellow,
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Potato ₹25/kg",
            color = Color.Yellow,
            fontSize = 32.sp
        )
    }
}

