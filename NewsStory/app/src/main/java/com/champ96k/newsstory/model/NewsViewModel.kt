package com.champ96k.newsstory.model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.champ96k.newsstory.apiServices.newsResponse
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {

    private val _newsFromServerState = mutableStateOf(NewsState())
    val newsFromServerState:State<NewsState> = _newsFromServerState

    data class NewsState(
        val loading:Boolean = true,
        val newsModel: NewsResponse? = null,
        val error:String? = null,
    )

    init {  fetchNews() }

    private fun fetchNews() {
        viewModelScope.launch {
            try {
                val  response = newsResponse.getNewsFromServer()
                println("Response type info: ${response.articles}")
                _newsFromServerState.value = _newsFromServerState.value.copy(
                    loading = false,
                    newsModel = response,
                    error = null
                )

            } catch (e:Exception) {
                println("Exception occurred: $e")
                _newsFromServerState.value = _newsFromServerState.value.copy(
                    loading = false,
                    newsModel = null,
                    error = "Something went wrong: $e"
                )
            }
        }
    }
}

