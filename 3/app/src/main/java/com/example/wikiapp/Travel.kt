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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Notifications
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            ScrollableTabRow(
                edgePadding = 16.dp,
                selectedTabIndex = selectedTab,
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
            AppNavHost(
                navController,
                baseTab,
                modifier = Modifier.weight(1f) // 나머지 공간 채우기
            )
        }
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
                    Tabs.POPULAR -> PopularScreen(navController)
                    Tabs.RECENT -> RecentScreen()
                    Tabs.MOST -> MostScreen()
                    Tabs.FAVORITE -> FavoriteScreen()
                    Tabs.PICK -> PickScreen()
                    Tabs.DUMMY -> DummyScreen()
                }
            }
        }
        composable("detail") {
            DetailScreen()
        }
    }
}

@Composable
fun DetailScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD0CBFF))
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .clip(
                    RoundedCornerShape(
                        topStart = 48.dp,
                        topEnd = 48.dp,
                    )
                )
                .background(Color.White)
                .align(Alignment.BottomCenter)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(
                        top = 36.dp,
                        bottom = 100.dp,
                        start = 36.dp,
                        end = 36.dp)
            ) {
                Text(
                    text = "Mount Fuji",
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    Icon(
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = "Location",
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Honshu, Japan",
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Row {
                    repeat(5) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            tint = Color.Yellow,
                            contentDescription = "Star",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "4.5",
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .width(128.dp)
                            .height(48.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .background(Color.LightGray)
                        ,
                    ){
                        IconButton(onClick = {},
                            modifier = Modifier
                                .offset(x = -(5).dp)
                                .clip(RoundedCornerShape(40))
                                .background(MaterialTheme.colorScheme.primaryContainer)
                        ){
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                        Text(
                            text = "5",
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                        )
                        IconButton(onClick = {},
                            modifier = Modifier
                                .offset(x = 5.dp)
                                .clip(RoundedCornerShape(50))
                                .background(MaterialTheme.colorScheme.primaryContainer)
                        ){
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "Notification",
                            tint = Color.Black,
                            modifier = Modifier.size(32.dp)
                        )
                        Text(text = "5 Days",
                            fontSize = 20.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,)
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Description",
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                            " Dignissim eget amet viverra eget fames rhoncus." +
                            " Eget enim venenatis enim porta egestas malesuada et." +
                            " Consequat mauris lacus euismod montes." +
                            " Consequat mauris lacus euismod montes." +
                            " Consequat mauris lacus euismod montes." +
                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                            " Dignissim eget amet viverra eget fames rhoncus." +
                            " Eget enim venenatis enim porta egestas malesuada et." +
                            " Consequat mauris lacus euismod montes." +
                            " Consequat mauris lacus euismod montes." +
                            " Consequat mauris lacus euismod montes.",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(Color.White)
                    .padding(
                        vertical = 12.dp,
                        horizontal = 36.dp),
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = "$400",
                    fontSize = 32.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "/Package",
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.width(36.dp))
                TextButton(onClick = {},
                    modifier = Modifier
                        .width(200.dp)
                        .clip(RoundedCornerShape(50))
                        .background(MaterialTheme.colorScheme.primary)
                ) {
                    Text(
                        text = "Book Now",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun PopularScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(
                top = 24.dp,
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
                BannerComponent(navController = navController)
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
                BannerComponent(false, navController)
            }
        }
    }
}

@Composable
fun BannerComponent(isLarge: Boolean = true, navController: NavHostController){
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
            .clickable(
                onClick = {
                    navController.navigate("detail")
                },
            )
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
                    style = if(isLarge) MaterialTheme.typography.titleSmall
                        else MaterialTheme.typography.bodySmall,
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