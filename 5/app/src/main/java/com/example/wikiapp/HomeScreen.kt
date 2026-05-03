package com.example.wikiapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    onNavigate: (String) -> Unit = {},
) {
    var count: Int by remember { mutableIntStateOf(0) }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Counter(
            count = count,
            onChange = { count++ }
        )
        Text(
            text = "Home Screen",
        )
        Button(onClick = {
            onNavigate("sub")
        }) {
            Text(text = "Go SubScreen")
        }
    }
}