package com.example.calucatorfinal

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
//import com.example.calucatorfinal.ui.theme.CalucatorfinalTheme
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.calucatorfinal.ui.theme.CalucatorfinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalucatorfinalTheme(){
                  Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                      Greeting(
                          name = "tejas",
                          modifier = Modifier.padding(padding)
                      )
                  }
              }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier.padding(20.dp),
        textAlign = TextAlign.Center
    )
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    CalucatorfinalTheme {
//        Greeting("Android")
//    }
//}