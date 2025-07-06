package com.champ96k.newsstory

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.champ96k.newsstory.constants.Screen
import com.champ96k.newsstory.view.HomeScreen
import com.champ96k.newsstory.view.DetailsScreen


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {MyApp()}
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyApp() {

    //Step 1: Initialize the NavController
    val navController = rememberNavController()

    //Step 2: Set up the NavHost
    NavHost(navController = navController, startDestination = Screen.HomeScreen.name) {
        composable(route = Screen.HomeScreen.name) {
            HomeScreen(navController)
        }

        composable(
            route = "${Screen.DetailsScreen.name}?url={url}",
            arguments = listOf(
            navArgument("url") {
                type = NavType.StringType
                nullable = true
            }
        ))  { it ->
            val articleJson = it.arguments?.getString("url") ?: ""
            DetailsScreen(url = articleJson)
        }
    }


}


