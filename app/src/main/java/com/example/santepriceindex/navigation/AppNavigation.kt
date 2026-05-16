package com.example.santepriceindex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.santepriceindex.HomeScreen
import com.example.santepriceindex.LoginScreen
import com.example.santepriceindex.SignupScreen
import com.example.santepriceindex.AddProductScreen
import com.example.santepriceindex.ViewProductsScreen
import com.example.santepriceindex.screens.CalculatorScreen

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
    }
}