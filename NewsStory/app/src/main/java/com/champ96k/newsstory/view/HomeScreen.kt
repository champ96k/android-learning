package com.champ96k.newsstory.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.champ96k.newsstory.constants.Screen
import com.champ96k.newsstory.ui.theme.NewsStoryTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(navController: NavController) {
    NewsStoryTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { AddAppBar() },
        ) { innerPadding ->
            NewsFeed(modifier = Modifier.padding(innerPadding), onCardClick = { url ->
                println("Card clicked: $url")
                if (!url.isNullOrEmpty()) {
                    navController.navigate("${Screen.DetailsScreen.name}?url=$url")
                }
            })
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAppBar() {
    TopAppBar(
        title = { Text("NewsX") },
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search")
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Notifications, contentDescription = "notification")
            }
        },
    )
}
