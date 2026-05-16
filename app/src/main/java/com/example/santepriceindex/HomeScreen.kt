package com.example.santepriceindex

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Sante Price Index",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {

                navController.navigate("priceboard")
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Price Board")
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {

                navController.navigate("calculator")
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Profit Calculator")
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {

                navController.navigate("addproduct")
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Add Product")
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {

                navController.navigate("viewproducts")
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("View Products")
        }

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = {

                FirebaseAuth.getInstance().signOut()

                navController.navigate("login") {
                    popUpTo("home") {
                        inclusive = true
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Logout")
        }
    }
}