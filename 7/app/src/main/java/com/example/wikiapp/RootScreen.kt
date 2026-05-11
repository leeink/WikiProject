package com.example.wikiapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wikiapp.viewmodel.ProfileViewModel

enum class Page(
    val route: String
) {
    HOME("home"),
    PROFILE("profile"),
    EDIT_PROFILE("edit_profile")
}


fun NavHostController.handleNavigation(route: String) {
    when (route) {
        "home" -> navigate("home") {
            popUpTo("home") { inclusive = false }
            launchSingleTop = true
        }
        "profile" -> navigate("profile") {
            popUpTo("profile") { inclusive = false }
            launchSingleTop = true
        }
        "edit_profile" -> navigate("edit_profile")
        else -> popBackStack()
    }
}

@Composable
fun RootScreen() {
    val navController = rememberNavController()
    var selectedPage by remember { mutableIntStateOf(Page.HOME.ordinal) }

    Scaffold(
        bottomBar = {
            BottomAppBar(windowInsets = NavigationBarDefaults.windowInsets) {
                Page.entries.forEachIndexed { index, page ->
                    NavigationBarItem(
                        selected = index == selectedPage,
                        onClick = {
                            navController.navigate(page.route) {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                            selectedPage = index
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Home,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = page.route.uppercase(),
                            )
                        }
                    )
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column {
            NavHost(
                modifier = Modifier.padding(innerPadding),
                navController = navController,
                startDestination = "home"
            ) {
                composable("home") {
                    HomeScreen(onNavigate = navController::handleNavigation)
                }
                composable("profile") {
                    val viewModel: ProfileViewModel = viewModel(it)
                    ProfileScreen(viewModel, onNavigate = { navController.navigate(it) })
                }
                composable("edit_profile") {
                    val parentEntry = remember(it) { navController.getBackStackEntry("profile") }
                    val viewModel: ProfileViewModel = viewModel(parentEntry)
                    EditProfileScreen(viewModel, onNavigate = { navController.popBackStack() })
                }
            }
        }
    }
}