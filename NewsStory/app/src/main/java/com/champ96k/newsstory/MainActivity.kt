package com.champ96k.newsstory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.champ96k.newsstory.ui.theme.NewsStoryTheme
import com.champ96k.newsstory.view.NewsFeed

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsStoryTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    ) { innerPadding ->
                    NewsFeed(modifier = Modifier.padding(innerPadding))
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