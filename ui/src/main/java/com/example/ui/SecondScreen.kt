package com.example.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SecondScreen() {
    Column {
        Text("SecondScreen")
        Button(onClick = {
            // openShowKast()
        }) {
            Text(text = "Some button")
        }
    }
}

@Preview
@Composable
fun SecondScreenPreview() {
    SecondScreen()
}