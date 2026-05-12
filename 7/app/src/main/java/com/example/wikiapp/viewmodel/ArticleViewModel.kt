package com.example.wikiapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wikiapp.fakeArticles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.milliseconds

class ArticleViewModel : ViewModel() {
    private val _articles = MutableStateFlow(ArticleUiState())
    val articles: StateFlow<ArticleUiState> = _articles.asStateFlow()

    init {
        fetchArticles()
    }

    fun fetchArticles() {
        viewModelScope.launch {
            _articles.update { it.copy(isLoading = true, message = "Fetching Articles...") }

            try {
                val articles = withContext(Dispatchers.IO) {
                    delay(5000.milliseconds)
                    fakeArticles
                }
                _articles.update { it.copy(articles = articles, isLoading = false, isError = false, message = "Done") }
            } catch (e: Exception) {
                _articles.update { it.copy(isLoading = false, isError = true, message = e.message ?: "Not Found Error...") }
            }
        }
    }
}
