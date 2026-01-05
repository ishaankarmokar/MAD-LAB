package com.example.loginmenu_kotlynversion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginmenu_kotlynversion.ui.theme.LoginMenu_KotlynVersionTheme
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import android.widget.Toast

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // This is our main screen function
            LoginScreen()
        }
    }
}

@Composable
fun LoginScreen() {
    // 1. Create variables to hold the text
    // 'mutableStateOf' tells Compose to redraw when these change
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    // 2. Arrange elements in a Column
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation(),
            keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(
                keyboardType = androidx.compose.ui.text.input.KeyboardType.Password
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                if (username == "ishaan" && password == "password") {
                    Toast.makeText(context, "Verified for $username", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Incorrect username or password", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text("Enter")
            }

            Button(onClick = {
                username = ""
                password = ""
                Toast.makeText(context, "Cleared", Toast.LENGTH_SHORT).show()
            }) {
                Text("Clear")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginMenu_KotlynVersionTheme {
        LoginScreen()
    }
}