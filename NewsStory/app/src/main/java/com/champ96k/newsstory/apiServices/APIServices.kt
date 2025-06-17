package com.champ96k.newsstory.apiServices

import com.champ96k.newsstory.model.NewsResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private val retrofit = Retrofit.Builder().baseUrl("https://newsapi.org/v2/").addConverterFactory(GsonConverterFactory.create()).build()

val newsResponse = retrofit.create(APIServices::class.java)

interface APIServices {

    @GET("everything?q=nashik&apiKey=ba8a666d9c564a6284ecc8c224d90a0c")
    suspend fun getNewsFromServer(): NewsResponse

}