package com.example.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.airbnb.android.showkase.models.Showkase

@Composable
fun MyScreen() {
    val context = LocalContext.current
    Column {
        Text("MyScreen")
        Button(modifier = Modifier, onClick = {
            context.startActivity(Showkase.getBrowserIntent(context))
        }) {
            Text(text = "ShowKast")
        }
    }
}