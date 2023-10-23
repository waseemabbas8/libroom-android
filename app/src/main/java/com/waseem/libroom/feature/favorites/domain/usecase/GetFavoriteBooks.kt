package com.waseem.libroom.feature.favorites.domain.usecase

import com.waseem.libroom.core.SResult
import com.waseem.libroom.core.usecase.UseCase
import com.waseem.libroom.feature.book.domain.Book
import com.waseem.libroom.feature.book.domain.BookRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

interface GetFavoriteBooks : UseCase<List<Book>, GetFavoriteBooks.Params> {
    data class Params(val userId: String)
}

class GetFavoriteBooksImpl(
    private val dispatcher: CoroutineDispatcher,
    private val repository: BookRepository
) : GetFavoriteBooks {
    override suspend fun invoke(params: GetFavoriteBooks.Params): SResult<List<Book>> {
        return withContext(dispatcher) {
            repository.getFavoritesByUserId(params.userId)
        }
    }
}