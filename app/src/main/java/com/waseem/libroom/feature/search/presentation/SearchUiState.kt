package com.waseem.libroom.feature.search.presentation

import com.waseem.libroom.feature.author.presentation.AuthorUiState
import com.waseem.libroom.feature.category.presentation.CategoryUiState

data class SearchByContent(
    val searchBoxValue: String = "",
    val topAuthors: List<AuthorUiState> = emptyList(),
    val topCategories: List<CategoryUiState> = emptyList()
)

data class SearchResults(
    val searchBoxValue: String,
    val topAuthors: List<AuthorUiState>,
    val topCategories: List<CategoryUiState>
)