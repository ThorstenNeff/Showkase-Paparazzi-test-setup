package com.example.ui.music.player

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PlayerScreen() {
    Column {
        Box(Modifier.fillMaxSize().background(Color.Red)) {
            Column(
                modifier = Modifier.align(Alignment.Center),
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center,
                    text = "Music player screen",
                )
            }
        }
    }
}

@Preview
@Composable
fun PlayerScreenPreview() {
    PlayerScreen()
}