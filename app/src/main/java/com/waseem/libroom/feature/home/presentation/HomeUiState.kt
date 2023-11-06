package com.waseem.libroom.feature.home.presentation

import com.waseem.libroom.feature.book.domain.Book
import com.waseem.libroom.feature.home.domain.HomeContent

data class HomeUiState (
    val recentReads: List<BooksListUiState>,
    val popularBooks: List<BooksListUiState>
)

data class BooksListUiState(
    val id: String,
    val title: String,
    val author: String,
    val cover: String
)

fun HomeContent.toUiState(): HomeUiState = HomeUiState(
    recentReads = recentReads.map { it.toBooksListUiState() },
    popularBooks = popularBooks.map { it.toBooksListUiState() }
)

fun Book.toBooksListUiState(): BooksListUiState = BooksListUiState(
    id = id,
    title = title,
    author = authorName,
    cover = cover
)