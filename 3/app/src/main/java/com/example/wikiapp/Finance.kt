package com.example.wikiapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wikiapp.ui.theme.BackgroundDarkModeAndLetters
import com.example.wikiapp.ui.theme.BackgroundGreenWhite
import com.example.wikiapp.ui.theme.LettersAndIcons
import com.example.wikiapp.ui.theme.LightGreen
import com.example.wikiapp.ui.theme.MainGreen
import com.example.wikiapp.ui.theme.OceanBlueButton
import com.example.wikiapp.ui.theme.WikiappTheme

@Composable
fun Finance(){
    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 40.dp,
                            topEnd = 40.dp,
                        )
                    ),
                windowInsets = WindowInsets(bottom = 0),
                containerColor = LightGreen,
            ){

            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .background(MainGreen)
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            Column(
                modifier = Modifier.padding(
                    top = 40.dp,
                    start = 20.dp,
                    end = 20.dp,
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = "Hi, Welcome to Finance App!",
                            style = MaterialTheme.typography.titleLarge,
                            color = BackgroundDarkModeAndLetters
                        )
                        Text(
                            text = "Good Morning",
                            style = MaterialTheme.typography.titleSmall,
                            color = BackgroundDarkModeAndLetters
                        )
                    }

                    IconButton(onClick = {}) {
                        Box(
                            modifier = Modifier
                                .clip(shape = CircleShape)
                                .background(Color.White)
                        )
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = null,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(40.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Column {
                        Text(
                            text = "Total Balance",
                            style = MaterialTheme.typography.titleSmall,
                            color = LettersAndIcons
                        )
                        Text(
                            text = "$7,750.00",
                            fontSize = 24.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    VerticalDivider(
                        color = Color.White,
                        modifier = Modifier.height(50.dp)
                    )
                    Column {
                        Text(
                            text = "Total Balance",
                            style = MaterialTheme.typography.titleSmall,
                            color = LettersAndIcons
                        )
                        Text(
                            text = "$7,750.00",
                            fontSize = 24.sp,
                            color = OceanBlueButton,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(36.dp)
                            .clip(shape = RoundedCornerShape(20.dp))
                            .background(BackgroundDarkModeAndLetters)
                    ) {
                        Text(
                            text = "30%",
                            style = MaterialTheme.typography.titleSmall,
                            color = BackgroundGreenWhite,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .offset(x = 20.dp, y = 10.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .height(36.dp)
                            .clip(shape = RoundedCornerShape(20.dp))
                            .background(BackgroundGreenWhite)
                            .align(Alignment.TopEnd)
                    ) {
                        Text(
                            text = "$20,000.00",
                            style = MaterialTheme.typography.titleSmall,
                            color = LettersAndIcons,
                            modifier = Modifier
                                .offset(x = 160.dp, y = 10.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        modifier = Modifier
                            .size(18.dp)
                    )
                    Text(
                        text = "30% of your expenses, looks good.",
                        style = MaterialTheme.typography.titleSmall,
                        color = LettersAndIcons,
                        textAlign = TextAlign.Center,
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(520.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 80.dp,
                            topEnd = 80.dp,
                        )
                    )
                    .background(BackgroundGreenWhite)
                    .align(Alignment.BottomCenter)

            ) {

            }
        }
    }
}