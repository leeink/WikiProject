package com.example.wikiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wikiapp.ui.theme.WikiAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WikiAppTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = Modifier
                .myBoxModifier(MaterialTheme.colorScheme.error)
        )
        Box(
            modifier = Modifier
                .myBoxModifier(MaterialTheme.colorScheme.error)
        )
        Box(
            modifier = Modifier
                .myBoxModifier(MaterialTheme.colorScheme.error)
        )
        Box(
            modifier = Modifier
                .myBoxModifier(MaterialTheme.colorScheme.error)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WikiAppTheme {
        App()
    }
}

fun Modifier.myBoxModifier(color: Color): Modifier{
    return Modifier
        .size(100.dp)
        .background(color)
}