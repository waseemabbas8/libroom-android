package com.waseem.libroom.feature.author.presentation

import com.waseem.libroom.feature.author.domain.Author

data class AuthorUiState(
    val id: String,
    val name: String,
    val profileImage: String
)

fun Author.toUiState() = AuthorUiState(
    id = id,
    name = name,
    profileImage = image
)

data class AuthorDetailUiState(
    val name: String,
    val profileImage: String,
    //TODO: add other properties here
)
