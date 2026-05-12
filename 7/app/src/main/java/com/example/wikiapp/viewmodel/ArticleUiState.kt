package com.example.wikiapp.viewmodel

data class ArticleUiState(
    val articles: List<Article> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val message: String = "Fetching Articles...",
)