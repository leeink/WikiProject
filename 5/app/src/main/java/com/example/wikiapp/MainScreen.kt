package com.example.wikiapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

fun NavHostController.handleNavigation(route: String) {
    when(route){
        "home" -> navigate("home")
        "sub" -> navigate("sub")
        else -> popBackStack()
    }
}

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    NavHost(
        modifier = Modifier
            .safeContentPadding()
            .fillMaxSize(),
        navController = navController,
        startDestination = "home") {
        composable("home") {
            HomeScreen(
                navController::handleNavigation
            )
        }
        composable("sub") {
            SubScreen(
                navController::handleNavigation
            )
        }
    }
}

@Composable
fun Counter(count: Int, onChange: () -> Unit) {
    Text(
        text = "$count",
        modifier = Modifier
            .clickable(
                onClick = onChange,
            )
    )
}