package com.example.santepriceindex.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Sante Price Index",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(30.dp))

        ElevatedButton(

            onClick = {
                navController.navigate("calculator")
            },

            modifier = Modifier.fillMaxWidth(),

            shape = MaterialTheme.shapes.large
        ) {

            Text("Profit Calculator")
        }

        Spacer(modifier = Modifier.height(15.dp))

        ElevatedButton(

            onClick = {
                navController.navigate("board")
            },

            modifier = Modifier.fillMaxWidth(),

            shape = MaterialTheme.shapes.large
        ) {

            Text("Price Board")
        }

        Spacer(modifier = Modifier.height(15.dp))

        ElevatedButton(

            onClick = {
                navController.navigate("addproduct")
            },

            modifier = Modifier.fillMaxWidth(),

            shape = MaterialTheme.shapes.large
        ) {

            Text("Add Product")
        }

        Spacer(modifier = Modifier.height(15.dp))

        ElevatedButton(

            onClick = {
                navController.navigate("viewproducts")
            },

            modifier = Modifier.fillMaxWidth(),

            shape = MaterialTheme.shapes.large
        ) {

            Text("View Products")
        }

        Spacer(modifier = Modifier.height(15.dp))

        ElevatedButton(

            onClick = {

                FirebaseAuth.getInstance().signOut()

                navController.navigate("login") {

                    popUpTo("home") {
                        inclusive = true
                    }
                }
            },

            modifier = Modifier.fillMaxWidth(),

            shape = MaterialTheme.shapes.large
        ) {

            Text("Logout")
        }
    }
}