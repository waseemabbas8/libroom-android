package com.waseem.libroom.feature.favorites.presentation

import com.waseem.libroom.feature.home.presentation.BooksListUiState

data class FavoritesUiState(
    val searchBoxValue: String = "",
    val favoriteBooks: List<BooksListUiState>
)