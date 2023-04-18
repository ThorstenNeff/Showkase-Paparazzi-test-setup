package com.example.paparazzisample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.android.showkase.models.Showkase
import com.example.paparazzisample.ui.theme.PaparazziSampleTheme
import com.example.ui.HomeActivity
import com.example.ui.HomeScreen
import com.example.ui.MyScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaparazziSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Button(onClick = {
                            startHome()

                        }) {
                            Text("Start HomeActivity")
                        }
                    }
                }
            }
        }
    }

    fun startHome() {
        startActivity(Intent(this, HomeActivity::class.java))
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PaparazziSampleTheme {
        Greeting("Android")
    }
}