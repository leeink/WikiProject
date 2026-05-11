package com.example.wikiapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(onNavigate: (String) -> Unit = {},){
    Column {
        Text(text = "Home Screen")
    }
}