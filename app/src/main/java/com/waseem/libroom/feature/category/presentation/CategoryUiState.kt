package com.waseem.libroom.feature.category.presentation

import com.waseem.libroom.feature.category.domain.BookCategory

data class CategoryUiState(
    val id: String,
    val title: String,
    val thumbnail: String
)

fun BookCategory.toUiState() = CategoryUiState(
    id = id,
    title = title,
    thumbnail = thumbnail
)
