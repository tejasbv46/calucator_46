package com.example.calucatorfinal.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var usernameError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 20.dp)
            ,color = Color.Black

        )

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            textStyle = LocalTextStyle.current.copy(color = Color.Black) ,
            colors = OutlinedTextFieldDefaults.colors(
              //  focusedTextColor = Color.Black,
                //unfocusedTextColor = Color.Red,
                cursorColor = Color.Black
                ,focusedBorderColor = Color.Magenta, unfocusedBorderColor = Color.Red,
           unfocusedLeadingIconColor = Color.Red, focusedLeadingIconColor = Color.Magenta

            ),

            leadingIcon = {
                Icon(
                    Icons.Default.AccountCircle,
                    contentDescription = null,
                   // tint = Color.Black
                )
            },
            label = { Text("username") },
            modifier = Modifier.fillMaxWidth(0.9f),
            shape = RoundedCornerShape(60.dp)
        )
        Text(
        text = usernameError,
        color = Color.Black,
        fontSize = 12.sp,

        )
       // व्यक्ति

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            textStyle = LocalTextStyle.current.copy(color = Color.Black),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black, unfocusedTextColor = Color.Red, cursorColor = Color.Black
                , focusedBorderColor = Color.Magenta, unfocusedBorderColor = Color.Red,
                unfocusedLeadingIconColor = Color.Red, focusedLeadingIconColor = Color.Magenta

            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                   // tint = Color.Black,

                )
            },
            label = { Text("password") },
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription =null ,
                        tint=if (passwordVisible) Color.DarkGray else Color.Black
                    )

                }
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(mask ='*' ),

            modifier = Modifier.fillMaxWidth(0.9f),
            shape = RoundedCornerShape(60.dp)
        )
        Text (
                text =passwordError,
        color = Color.Black,
        fontSize = 12.sp
        )

        Button (
            onClick = {
                scope.launch {  /* Handle Login */
                    if (username.isEmpty()) {
                        usernameError = "username cannot be empty"
                    }

                    if (password.isEmpty()) {
                        passwordError = "password cannot be empty"
                    }

                    delay(5000)

                    usernameError = ""
                    passwordError = ""
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier.fillMaxWidth(0.6f),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text("Login")
        }
    }
}
