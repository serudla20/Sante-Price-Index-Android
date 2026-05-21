package com.example.santepriceindex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.santepriceindex.AddProductScreen
import com.example.santepriceindex.LoginScreen
import com.example.santepriceindex.Product
import com.example.santepriceindex.SignupScreen
import com.example.santepriceindex.ViewProductsScreen
import com.example.santepriceindex.screens.CalculatorScreen
import com.example.santepriceindex.screens.EditProductScreen
import com.example.santepriceindex.screens.HomeScreen
import com.example.santepriceindex.screens.PriceBoardScreen


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {

            LoginScreen(navController)
        }

        composable("signup") {

            SignupScreen(navController)
        }

        composable("home") {

            HomeScreen(navController)
        }

        composable("addproduct") {

            AddProductScreen(navController)
        }

        composable("viewproducts") {

            ViewProductsScreen(navController)
        }

        composable("calculator") {

            CalculatorScreen(navController)
        }

        composable("board") {

            PriceBoardScreen()
        }

        composable(

            route = "edit/{id}/{name}/{cost}/{selling}"

        ) { backStackEntry ->

            val id = backStackEntry.arguments
                ?.getString("id") ?: ""

            val name = backStackEntry.arguments
                ?.getString("name") ?: ""

            val cost = backStackEntry.arguments
                ?.getString("cost") ?: ""

            val selling = backStackEntry.arguments
                ?.getString("selling") ?: ""

            val product = Product(
                id,
                name,
                cost,
                selling
            )

            EditProductScreen(
                navController = navController,
                product = product
            )
        }
    }
}