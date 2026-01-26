package com.example.wikiapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wikiapp.ui.theme.BackgroundDarkModeAndLetters
import com.example.wikiapp.ui.theme.BackgroundGreenWhite
import com.example.wikiapp.ui.theme.LettersAndIcons
import com.example.wikiapp.ui.theme.LightBlueButton
import com.example.wikiapp.ui.theme.LightGreen
import com.example.wikiapp.ui.theme.MainGreen
import com.example.wikiapp.ui.theme.OceanBlueButton
import com.example.wikiapp.ui.theme.WikiappTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Finance() {
    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 40.dp,
                            topEnd = 40.dp,
                        )
                    ),
                containerColor = LightGreen,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    repeat(5) {
                        IconButton(
                            onClick = {},
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Notifications,
                                contentDescription = null,
                                modifier = Modifier.size(48.dp),
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .background(MainGreen)
                .fillMaxSize()
            //.padding(paddingValues)
        ) {
            Column(
                modifier = Modifier.padding(
                    top = 60.dp,
                    start = 30.dp,
                    end = 30.dp,
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
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
                    .height(600.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 80.dp,
                            topEnd = 80.dp,
                        )
                    )
                    .background(BackgroundGreenWhite)
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(160.dp)
                        .clip(
                            shape = RoundedCornerShape(
                                40.dp
                            )
                        )
                        .background(MainGreen)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(
                                vertical = 20.dp,
                                horizontal = 30.dp
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .background(Color.White)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Savings\nOn Goals",
                            style = MaterialTheme.typography.titleSmall,
                            textAlign = TextAlign.Center,
                        )
                    }
                    VerticalDivider(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxHeight(0.8f),
                        color = Color.White,
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(
                                vertical = 20.dp,
                                horizontal = 10.dp
                            ),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceAround,
                    ) {

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                            )
                            Column(
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text(
                                    text = "Revenue Last Week",
                                    style = MaterialTheme.typography.titleSmall,
                                )
                                Text(
                                    text = "$4.000.000",
                                    style = MaterialTheme.typography.titleSmall,
                                )
                            }
                        }
                        HorizontalDivider(
                            modifier = Modifier.fillMaxWidth(),
                            color = Color.White,
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                            )
                            Column(
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text(
                                    text = "Food Last Week",
                                    style = MaterialTheme.typography.titleSmall,
                                )
                                Text(
                                    text = "-$100.00",
                                    color = OceanBlueButton,
                                    style = MaterialTheme.typography.titleSmall,
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                PrimaryTabRow(
                    selectedTabIndex = 0,
                    containerColor = LightGreen,
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .clip(shape = RoundedCornerShape(20.dp)),
                ) {
                    Tab(
                        selected = true,
                        onClick = {},
                        text = {
                            Text(
                                text = "Daily",
                                style = MaterialTheme.typography.titleSmall,
                            )
                        }
                    )
                    Tab(
                        selected = false,
                        onClick = {},
                        text = {
                            Text(
                                text = "Weekly",
                                style = MaterialTheme.typography.titleSmall,
                            )
                        }
                    )
                    Tab(
                        selected = false,
                        onClick = {},
                        text = {
                            Text(
                                text = "Monthly",
                                style = MaterialTheme.typography.titleSmall,
                            )
                        }
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 20.dp,
                            horizontal = 30.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    repeat(3) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(shape = RoundedCornerShape(8.dp))
                                        .background(LightBlueButton)
                                        .padding(8.dp)
                                )
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Text(
                                        text = "Salary",
                                        style = MaterialTheme.typography.bodyMedium,
                                    )
                                    Text(
                                        text = "18:27 - April 30",
                                        style = MaterialTheme.typography.titleSmall,
                                        color = OceanBlueButton,
                                    )
                                }
                            }
                            VerticalDivider(
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(1.dp),
                                color = MainGreen,
                            )

                            Text(
                                text = "Monthly",
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier.width(60.dp)
                            )

                            VerticalDivider(
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(1.dp),
                                color = MainGreen,
                            )

                            Text(
                                text = "$4,000.00",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }
                }
            }
        }
    }
}