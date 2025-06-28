package com.champ96k.newsstory.view


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.champ96k.newsstory.model.NewsViewModel
import com.champ96k.newsstory.ui.theme.NewsStoryTheme
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun NewsFeed(modifier: Modifier) {


    val newsViewModel: NewsViewModel = viewModel()
    val newsFromServerModel = newsViewModel.newsFromServerState.value

    when {
        newsFromServerModel.loading ->{
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
        } newsFromServerModel.error !=null -> {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(newsFromServerModel.error)
        }

        } else -> {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {

            println("News count - : ${newsFromServerModel.newsModel?.articles?.size}")

            item {
                Row(modifier = Modifier.padding(bottom = 24.dp)) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")
                    Spacer(Modifier.weight(2f))
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "search", modifier = Modifier.padding(horizontal = 16.dp))
                    Icon(imageVector = Icons.Filled.Notifications, contentDescription = "notification")
                }
            }

//            item {
//                Card(
//                    modifier = modifier.fillMaxWidth()
//                        .height(140.dp),
//                    shape = CardDefaults.shape,
//                    colors = CardDefaults.cardColors(),
//                    elevation = CardDefaults.elevatedCardElevation(),
//                    border = BorderStroke(width = 0.5.dp, color = Color.Red)
//                ) {
//                    Image(
//                        painter = rememberAsyncImagePainter(model = "https://images.unsplash.com/photo-1523800378286-dae1f0dae656?q=80&w=1976&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"),
//                        contentDescription = "card image",
//                        modifier = Modifier.fillParentMaxSize(),
//                    )
//                }
//            }

            items(newsFromServerModel.newsModel?.articles ?: emptyList()) { article ->
                NewsCard(article = article)
            }
        }
        }

    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsStoryTheme {
        NewsFeed(Modifier.fillMaxWidth())
    }
}