package com.waseem.libroom.feature.home.presentation

import com.waseem.libroom.feature.book.domain.Book
import com.waseem.libroom.feature.home.domain.HomeContent

data class HomeUiState (
    val recentReads: List<BooksListUiState>,
    val popularBooks: List<BooksListUiState>
)

data class BooksListUiState(
    val title: String,
    val author: String,
    val cover: String
)

fun HomeContent.toUiState(): HomeUiState = HomeUiState(
    recentReads = recentReads.map { it.toBooksListUiState() },
    popularBooks = popularBooks.map { it.toBooksListUiState() }
)

fun Book.toBooksListUiState(): BooksListUiState = BooksListUiState(
    title = title,
    author = authorName,
    cover = cover
)