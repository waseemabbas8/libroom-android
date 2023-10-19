package com.waseem.libroom.feature.search.presentation

import com.waseem.libroom.core.BaseStateViewModel
import com.waseem.libroom.core.usecase.NoParams
import com.waseem.libroom.feature.author.domain.GetTopAuthors
import com.waseem.libroom.feature.author.presentation.toUiState
import com.waseem.libroom.feature.category.domain.usecase.GetTopCategories
import com.waseem.libroom.feature.category.presentation.toUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getTopAuthors: GetTopAuthors,
    private val getTopCategories: GetTopCategories,
    reducer: SearchReducer
) : BaseStateViewModel<SearchAction, SearchResult, SearchEvent, SearchState, SearchReducer>(
    initialState = SearchState.DefaultState,
    reducer = reducer
) {

    init {
        action(SearchAction.Load)
    }

    override fun SearchAction.process(): Flow<SearchResult> {
       return when(this) {
            SearchAction.Load -> loadContent()
            SearchAction.SearchViewClicked -> TODO()
            SearchAction.ViewAllAuthorsClicked -> TODO()
            SearchAction.ViewAllCategoriesClicked -> TODO()
        }
    }

    private fun loadContent(): Flow<SearchResult> {
        return flow<SearchResult> {
            getTopAuthors(params = NoParams)
                .onSuccess {authors ->
                    emit(SearchResult.TopAuthors(authors = authors.map { it.toUiState() }))
                }.onFailure {
                    throw IllegalStateException("Something has gone wrong!")
                }
            getTopCategories(params = NoParams)
                .onSuccess { categories ->
                    emit(SearchResult.TopCategories(categories = categories.map { it.toUiState() }))
                }.onFailure {
                    throw IllegalStateException("Something has gone wrong!")
                }
        }.onStart {
            emit(SearchResult.Loading)
        }.catch {
            emit(SearchResult.Failure)
        }
    }
}