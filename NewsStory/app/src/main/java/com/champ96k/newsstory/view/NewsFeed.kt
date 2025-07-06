package com.champ96k.newsstory.view


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import com.champ96k.newsstory.model.NewsViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewsFeed(modifier: Modifier,onCardClick: (String?) -> Unit) {

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
        LazyColumn(modifier = Modifier.padding(16.dp)) {

            println("News count - : ${newsFromServerModel.newsModel?.articles?.size}")

            item {
                Card(
                    modifier = modifier.fillMaxWidth()
                        .height(200.dp),
                    shape = CardDefaults.shape,
                    colors = CardDefaults.cardColors(),
                    elevation = CardDefaults.elevatedCardElevation(),
                    border = BorderStroke(width = 0.5.dp, color = Color.Red),
                    content = {
                        val lastImageUrl = newsFromServerModel.newsModel
                            ?.articles
                            ?.lastOrNull()
                            ?.urlToImage

                        val painter = rememberAsyncImagePainter(model = lastImageUrl)

                        Image(
                            painter,
                            contentDescription = "card image",
                            modifier = Modifier.fillParentMaxSize(),
                        )
                    },
                )
            }

            items(newsFromServerModel.newsModel?.articles ?: emptyList()) { article ->
                NewsCard(article = article, modifier = Modifier.clickable() {
                        println("Article URL: ${article?.url}")
                        onCardClick(article?.url)

                })
            }
        }
        }

    }

}


