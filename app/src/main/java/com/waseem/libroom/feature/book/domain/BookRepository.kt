package com.waseem.libroom.feature.book.domain

import com.waseem.libroom.core.SResult
import com.waseem.libroom.feature.home.domain.HomeContent

interface BookRepository {
    suspend fun getPopularBooks(): SResult<List<Book>>

    suspend fun getRecentReads(): SResult<List<Book>>

    suspend fun getHomeContent(): SResult<HomeContent>

    suspend fun getFavoritesByUserId(userId: String): SResult<List<Book>>
}