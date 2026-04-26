package com.example.wikiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
                .padding(paddingValues)) {
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
    ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
        ){
            repeat(3) {
                Box(
                    modifier = Modifier
                        .width(315.dp)
                        .height(235.dp)
                        .clip(
                            RoundedCornerShape(20.dp)
                        )
                        .background(Color.Blue)
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color(0xFFA0A0A0))
                            .align(Alignment.BottomCenter),
                    ){

                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))



        Spacer(Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = "Recommended",
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
            )
            Text(
                text = "View All",
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
            )
        }

        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun RecentScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ){
        Text(text = "Recent Screen")
    }
}

@Composable
fun MostScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ){
        Text(text = "Most Screen")
    }
}

@Composable
fun FavoriteScreen() {}

@Composable
fun PickScreen() {}

@Composable
fun DummyScreen() {}