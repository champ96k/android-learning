package com.champ96k.newsstory.model

data class NewsResponse(
    val articles: List<Article?>,
    val status: String,
    val totalResults: Int
)