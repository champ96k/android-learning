package com.champ96k.newsstory.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)


