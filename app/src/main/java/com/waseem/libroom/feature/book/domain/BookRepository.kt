package com.waseem.libroom.feature.book.domain

import com.waseem.libroom.feature.home.domain.HomeContent

interface BookRepository {
    suspend fun getPopularBooks(): Result<List<Book>>

    suspend fun getRecentReads(): Result<List<Book>>

    suspend fun getHomeContent(): Result<HomeContent>

    suspend fun getFavoritesByUserId(userId: String): Result<List<Book>>
}