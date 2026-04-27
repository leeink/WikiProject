package com.example.wikiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlin.collections.forEach
import kotlin.collections.forEachIndexed

enum class Tabs(
    val route: String,
    val label: String,
) {
    POPULAR("popular", "Popular"),
    RECENT("recent", "Recent"),
    MOST("most", "Most"),
    FAVORITE("favorite", "Favorite"),
    PICK("pick", "Pick"),
    DUMMY("dummy", "Dummy"),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Travel() {
    val navController = rememberNavController()
    val baseTab = Tabs.POPULAR
    var selectedTab by remember { mutableIntStateOf(baseTab.ordinal) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                    }
                },
                title = {
                    Text(
                        text = "Travel App",
                        style = MaterialTheme.typography.titleLarge,
                    )
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Profile"
                        )
                    }
                }
            )
        },
        bottomBar = {

        }
    ) { paddingValues ->
        ScrollableTabRow(
            edgePadding = 16.dp,
            selectedTabIndex = selectedTab,
            modifier = Modifier
                .padding(paddingValues)
        ) {
            Tabs.entries.forEachIndexed { index, tab ->
                Tab(
                    selected = selectedTab == index,
                    onClick = {
                        navController.navigate(tab.route)
                        selectedTab = index
                    },
                    text = {
                        Text(
                            text = tab.label,
                            style = MaterialTheme.typography.bodySmall,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                )
            }
        }
        AppNavHost(navController, baseTab, modifier = Modifier.padding(paddingValues))
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    startTabs: Tabs,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController,
        startDestination = startTabs.route,
        modifier = modifier.fillMaxSize(),
    ) {
        Tabs.entries.forEach { tab ->
            composable(tab.route) {
                when (tab) {
                    Tabs.POPULAR -> PopularScreen()
                    Tabs.RECENT -> RecentScreen()
                    Tabs.MOST -> MostScreen()
                    Tabs.FAVORITE -> FavoriteScreen()
                    Tabs.PICK -> PickScreen()
                    Tabs.DUMMY -> DummyScreen()
                }
            }
        }
    }
}

@Composable
fun PopularScreen() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(
                top = 80.dp,
                bottom = 0.dp,
                start = 24.dp,
                end = 24.dp
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
        ) {
            repeat(3) {
                BannerComponent()
            }
        }

        Spacer(Modifier.height(16.dp))



        Spacer(Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Recommended",
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
            )
            Text(
                text = "View All",
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                modifier = Modifier
                    .clickable(
                        onClick = {}
                    )
            )
        }

        Spacer(Modifier.height(16.dp))

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            maxItemsInEachRow = 2,
            modifier = Modifier
                .fillMaxWidth()
        ){
            repeat(6) {
                BannerComponent(false)
            }
        }
    }
}

@Composable
fun BannerComponent(isLarge: Boolean = true){
    Box(
        modifier = Modifier
            .width(if(isLarge) 315.dp else 170.dp)
            .height(if(isLarge) 250.dp else 170.dp)
            .clip(
                RoundedCornerShape(20.dp)
            )
            .graphicsLayer {
                compositingStrategy = CompositingStrategy.Offscreen
            }
            .background(Color(0xFFD0CBFF))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(if(isLarge) 80.dp else 56.dp)
                .clip(RoundedCornerShape(20.dp))
                .drawWithContent {
                    drawRect(
                        color = Color(0xFFA0A0A0),
                        blendMode = BlendMode.Multiply
                    )
                    drawContent()
                }
                .align(Alignment.BottomCenter),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Northern Mountain",
                    style = if(isLarge) MaterialTheme.typography.titleLarge
                        else MaterialTheme.typography.titleSmall,
                    maxLines = 1,
                    color = Color.White
                )
                Box(
                    modifier = Modifier
                        .size(if(isLarge) 24.dp else 16.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(Color.White),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        tint = Color.Red,
                        contentDescription = "Like",
                        modifier = Modifier.size(if (isLarge) 14.dp else 8.dp)
                    )
                }
            }
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row {
                    repeat(5) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            tint = Color.Yellow,
                            contentDescription = "Star",
                            modifier = Modifier.size(if(isLarge) 14.dp else 8.dp)
                        )
                    }
                }
                Text(
                    text = "4.5",
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun RecentScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Recent Screen")
    }
}


@Composable
fun MostScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Most Screen")
    }
}

@Composable
fun FavoriteScreen() {
}

@Composable
fun PickScreen() {
}

@Composable
fun DummyScreen() {
}