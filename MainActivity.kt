package com.example.loginpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var isLoggedIn by remember { mutableStateOf(false) }
    var isSignUpPage by remember { mutableStateOf(false) }
    var isForgotPasswordPage by remember { mutableStateOf(false) }

    when {
        isLoggedIn -> {
            InternalPage()
        }
        isSignUpPage -> {
            SignUpScreen(onSignUpSuccess = { isLoggedIn = true })
        }
        isForgotPasswordPage -> {
            ForgotPasswordScreen(onSubmit = {  })
        }
        else -> {
            LoginScreen(
                onLoginSuccess = { isLoggedIn = true },
                onSignUpClick = { isSignUpPage = true },
                onForgotPasswordClick = { isForgotPasswordPage = true }
            )
        }
    }
}

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onSignUpClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC0CB)) // Pink background color
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email/Full Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (email.text == "ranaarif" && password.text == "6614812") {
                    message = "Login Successful"
                    onLoginSuccess()
                } else {
                    message = "Invalid credentials"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = onSignUpClick) {
            Text("Don't have an account? Sign up")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = onForgotPasswordClick) {
            Text("Forgot Password")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = message, color = if (message.contains("Successful")) Color.Green else Color.Red)
    }
}

@Composable
fun ForgotPasswordScreen(onSubmit: (String) -> Unit) {
    var phone by remember { mutableStateOf(TextFieldValue("")) }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC0CB)) // Pink background color
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Enter your phone number") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (phone.text.isNotBlank()) {
                    message = "Password reset instructions sent to your phone number"
                    onSubmit(phone.text)
                } else {
                    message = "Please enter a valid phone number"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Text("Submit")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display message
        Text(text = message, color = if (message.contains("instructions sent")) Color.Green else Color.Red)
    }
}

@Composable
fun SignUpScreen(onSignUpSuccess: () -> Unit) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var phone by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var message by remember { mutableStateOf("") }

    var green = 0
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color( color =  green )) // Pink background color
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(" Enter your Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Enter your Phone") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Enter your  Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {
                if (name.text.isNotBlank() && phone.text.isNotBlank() && email.text.isNotBlank() && password.text.isNotBlank()) {
                    message = "Sign-up Successful"
                    onSignUpSuccess()
                } else {
                    message = "Please fill all box"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Text("Submit")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display message
        Text(text = message, color = if (message.contains("open Successful")) Color.Green else Color.Red)
    }
}

@Composable
fun InternalPage() {
    var green = 1
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(green)) // Pink background color
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "App is under development please wait for few days ",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Programmer: Rana Arif ",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
    }
}
