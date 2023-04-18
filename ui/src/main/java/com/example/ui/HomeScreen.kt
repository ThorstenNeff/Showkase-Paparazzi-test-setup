package com.example.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun HomeScreen() {
    Column {
        Text("Homescreen")
        Button(onClick = {
            // openShowKast()
        }) {
            Text(text = "ShowKast")
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}