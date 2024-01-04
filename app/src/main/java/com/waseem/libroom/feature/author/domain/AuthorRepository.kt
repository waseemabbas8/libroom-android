package com.waseem.libroom.feature.author.domain

interface AuthorRepository {
    suspend fun getAuthors(): Result<List<Author>>
}