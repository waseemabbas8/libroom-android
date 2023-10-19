package com.waseem.libroom.feature.category.domain.usecase

import com.waseem.libroom.core.SResult
import com.waseem.libroom.core.usecase.NoParams
import com.waseem.libroom.core.usecase.UseCase
import com.waseem.libroom.feature.category.domain.BookCategory
import com.waseem.libroom.feature.category.domain.CategoryRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

interface GetTopCategories : UseCase<List<BookCategory>, NoParams>

class GetTopCategoriesImpl(
    private val dispatcher: CoroutineDispatcher,
    private val repository: CategoryRepository
) : GetTopCategories {
    override suspend fun invoke(params: NoParams): SResult<List<BookCategory>> {
        return withContext(dispatcher) {
            repository.getTopCategories()
        }
    }
}