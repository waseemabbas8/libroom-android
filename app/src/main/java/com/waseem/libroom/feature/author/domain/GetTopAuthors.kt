package com.waseem.libroom.feature.author.domain

import com.waseem.libroom.core.SResult
import com.waseem.libroom.core.usecase.NoParams
import com.waseem.libroom.core.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

interface GetTopAuthors : UseCase<List<Author>, NoParams>

class GetTopAuthorsImpl(
    private val authorRepository: AuthorRepository,
    private val dispatcher: CoroutineDispatcher
) : GetTopAuthors {
    override suspend fun invoke(params: NoParams): SResult<List<Author>> {
        return withContext(dispatcher) {
            authorRepository.getAuthors()
        }
    }

}