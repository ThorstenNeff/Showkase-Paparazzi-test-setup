package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun SecondScreen() {
    Box(Modifier.fillMaxSize().background(Color.Yellow)) {
        Column(
            modifier = Modifier.align(Alignment.Center),
        ) {
            Text(
                style = TextStyle(fontSize = 18.sp),
                text = "SecondScreen"
            )
        }
    }
}

@Preview
@Composable
fun SecondScreenPreview() {
    SecondScreen()
}