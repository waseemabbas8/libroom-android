package com.waseem.libroom.feature.author.domain

import com.waseem.libroom.core.SResult

interface AuthorRepository {
    suspend fun getAuthors(): SResult<List<Author>>
}