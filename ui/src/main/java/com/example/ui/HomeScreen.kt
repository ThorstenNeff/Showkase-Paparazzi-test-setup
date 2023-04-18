package com.example.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.android.showkase.annotation.ShowkaseComposable


@ShowkaseComposable(
    name = "Custom name for component",
    group = "Custom group name"
)
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

@Preview(
    name = "Custom name for component",
    group = "Custom group name"
)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}