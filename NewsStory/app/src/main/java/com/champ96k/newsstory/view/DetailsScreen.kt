package com.champ96k.newsstory.view


import android.view.ViewGroup
import android.webkit.WebView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.champ96k.newsstory.ui.theme.NewsStoryTheme

@Composable
fun DetailsScreen(url: String) {

    NewsStoryTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
        ) { innerPadding ->

            AndroidView(
                modifier = Modifier.padding(innerPadding),
                factory = {
                    WebView(it).apply {
                        layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT,
                        )
                        settings.apply {
                            javaScriptEnabled = true
                            domStorageEnabled = true
                            loadWithOverviewMode = true
                            useWideViewPort = true
                        }
                    }
                },
                update = {
                    try {
                        if (url.isNotEmpty()) {
                            it.loadUrl(url)
                        }
                    } catch (e: Exception) {
                        println("Error loading URL: $e")
                    }
                }
            )
        }
    }


}