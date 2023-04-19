package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.android.showkase.models.Showkase
import com.example.ui.getBrowserIntent

@Composable
fun FirstScreen() {
    val context = LocalContext.current

    Box(Modifier.fillMaxSize().background(Color.Cyan)) {
        Column(
            modifier = Modifier.align(Alignment.Center),
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center,
                text = "First screen",
            )
            Button(modifier = Modifier, onClick = {
                context.startActivity(Showkase.getBrowserIntent(context))
            }) {
                Text(
                    style = TextStyle(fontSize = 18.sp),
                    text = "ShowKast"
                )
            }
        }
    }
}

@Preview
@Composable
fun FirstScreenPreview() {
    FirstScreen()
}