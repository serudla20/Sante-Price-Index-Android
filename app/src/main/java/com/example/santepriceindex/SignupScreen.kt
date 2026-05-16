package com.example.santepriceindex

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SignupScreen(navController: NavHostController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val auth = FirebaseAuth.getInstance()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Signup",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                if (email.isNotEmpty() && password.isNotEmpty()) {

                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->

                            if (task.isSuccessful) {

                                Toast.makeText(
                                    context,
                                    "Signup Successful",
                                    Toast.LENGTH_SHORT
                                ).show()

                                navController.navigate("login")

                            } else {

                                Toast.makeText(
                                    context,
                                    task.exception?.message,
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }

                } else {

                    Toast.makeText(
                        context,
                        "Enter email and password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        ) {

            Text("Signup")
        }

        Spacer(modifier = Modifier.height(10.dp))

        TextButton(
            onClick = {

                navController.navigate("login")
            }
        ) {

            Text("Already have an account? Login")
        }
    }
}

