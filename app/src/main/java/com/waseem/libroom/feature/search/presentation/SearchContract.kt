package com.waseem.libroom.feature.search.presentation

import com.waseem.libroom.core.mvi.MviAction
import com.waseem.libroom.core.mvi.MviEvent
import com.waseem.libroom.core.mvi.MviResult
import com.waseem.libroom.core.mvi.MviStateReducer
import com.waseem.libroom.core.mvi.MviViewState
import com.waseem.libroom.feature.author.presentation.AuthorUiState
import com.waseem.libroom.feature.category.presentation.CategoryUiState
import javax.inject.Inject

sealed class SearchAction : MviAction {
    object Load : SearchAction()
    object ViewAllAuthorsClicked : SearchAction()
    object ViewAllCategoriesClicked : SearchAction()
    object SearchViewClicked : SearchAction()
}

sealed class SearchResult : MviResult {
    object Loading : SearchResult()
    data class TopAuthors(val authors: List<AuthorUiState>) : SearchResult()
    data class TopCategories(val categories: List<CategoryUiState>) : SearchResult()
    object Failure : SearchResult()
}

sealed class SearchEvent : MviEvent {
    object ShowSearchDialog : SearchEvent()
    object NavigateToAuthors : SearchEvent()
    object NavigateToCategories : SearchEvent()
}

sealed class SearchState : MviViewState {
    object DefaultState : SearchState()
    object LoadingState : SearchState()
    data class SearchByState(val uiState: SearchByContent) : SearchState()
    data class SearchResultsState(val uiState: SearchResults) : SearchState()
    object ErrorState : SearchState()
}

class SearchReducer @Inject constructor() : MviStateReducer<SearchState, SearchResult> {
    override fun SearchState.reduce(result: SearchResult): SearchState {
        return when(val previousSate = this) {
            is SearchState.DefaultState -> previousSate + result
            is SearchState.ErrorState -> previousSate + result
            is SearchState.LoadingState -> previousSate + result
            is SearchState.SearchByState -> previousSate + result
            is SearchState.SearchResultsState -> TODO()
        }
    }

    private operator fun SearchState.DefaultState.plus(result: SearchResult): SearchState {
        return when(result) {
            SearchResult.Loading -> SearchState.LoadingState
            else -> throw IllegalStateException("unsupported")
        }
    }

    private operator fun SearchState.ErrorState.plus(result: SearchResult): SearchState {
        return when(result) {
            SearchResult.Loading -> SearchState.LoadingState
            else -> throw IllegalStateException("unsupported")
        }
    }

    private operator fun SearchState.LoadingState.plus(result: SearchResult): SearchState {
        return when(result) {
            SearchResult.Loading -> SearchState.LoadingState
            is SearchResult.TopCategories -> SearchState.SearchByState(
                uiState = SearchByContent(topCategories = result.categories)
            )
            is SearchResult.TopAuthors -> SearchState.SearchByState(
                uiState = SearchByContent(topAuthors = result.authors)
            )
            SearchResult.Failure -> SearchState.ErrorState
        }
    }

    private operator fun SearchState.SearchByState.plus(result: SearchResult): SearchState {
        return when(result) {
            SearchResult.Loading -> SearchState.LoadingState
            is SearchResult.TopAuthors -> SearchState.SearchByState(
                uiState = uiState.copy(topAuthors = result.authors)
            )
            is SearchResult.TopCategories -> SearchState.SearchByState(
                uiState = uiState.copy(topCategories = result.categories)
            )
            else -> throw IllegalStateException("unsupported")
        }
    }
}