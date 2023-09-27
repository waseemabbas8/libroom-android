package com.waseem.libroom.feature.home.domain

import com.waseem.libroom.core.SResult
import com.waseem.libroom.core.usecase.NoParams
import com.waseem.libroom.core.usecase.UseCase
import com.waseem.libroom.feature.book.domain.BookRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

interface GetHomeContent : UseCase<HomeContent, NoParams>

class GetHomeContentImpl(
    private val bookRepository: BookRepository,
    private val dispatcher: CoroutineDispatcher
) : GetHomeContent {
    override suspend fun invoke(params: NoParams): SResult<HomeContent> {
        return withContext(dispatcher) {
            bookRepository.getHomeContent()
        }
    }
}