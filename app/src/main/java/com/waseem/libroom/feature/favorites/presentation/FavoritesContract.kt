package com.waseem.libroom.feature.favorites.presentation

import com.waseem.libroom.core.mvi.MviAction
import com.waseem.libroom.core.mvi.MviEvent
import com.waseem.libroom.core.mvi.MviResult
import com.waseem.libroom.core.mvi.MviStateReducer
import com.waseem.libroom.core.mvi.MviViewState
import javax.inject.Inject

sealed class FavoritesAction : MviAction {
    object Load : FavoritesAction()
    object BookItemClicked : FavoritesAction()
}

sealed class FavoritesResult : MviResult {
    object Loading : FavoritesResult()
    data class FavoriteBooks(val uiState: FavoritesUiState) : FavoritesResult()
    object Failure : FavoritesResult()
}

sealed class FavoritesEvent : MviEvent {
    data class NavigateToBookDetail(val bookId: String) : FavoritesEvent()
}

sealed class FavoritesState : MviViewState {
    object DefaultState : FavoritesState()
    object LoadingState : FavoritesState()
    data class FavoriteBooksState(val uiState: FavoritesUiState) : FavoritesState()
    object ErrorState : FavoritesState()
}

class FavoriteReducer @Inject constructor() : MviStateReducer<FavoritesState, FavoritesResult> {
    override fun FavoritesState.reduce(result: FavoritesResult): FavoritesState {
        return when(val previousState = this) {
            is FavoritesState.DefaultState -> previousState + result
            is FavoritesState.ErrorState -> previousState + result
            is FavoritesState.FavoriteBooksState -> previousState + result
            is FavoritesState.LoadingState -> previousState + result
        }
    }

    private operator fun FavoritesState.DefaultState.plus(result: FavoritesResult): FavoritesState {
        return when(result) {
            FavoritesResult.Loading -> FavoritesState.LoadingState
            else -> throw IllegalStateException("unsupported")
        }
    }

    private operator fun FavoritesState.LoadingState.plus(result: FavoritesResult): FavoritesState {
        return when(result) {
            FavoritesResult.Failure -> FavoritesState.ErrorState
            is FavoritesResult.FavoriteBooks -> FavoritesState.FavoriteBooksState(uiState = result.uiState)
            FavoritesResult.Loading -> FavoritesState.LoadingState
        }
    }

    private operator fun FavoritesState.FavoriteBooksState.plus(result: FavoritesResult): FavoritesState {
        return when(result) {
            FavoritesResult.Loading -> FavoritesState.LoadingState
            is FavoritesResult.FavoriteBooks -> FavoritesState.FavoriteBooksState(uiState = result.uiState)
            else -> throw IllegalStateException("unsupported")
        }
    }

    private operator fun FavoritesState.ErrorState.plus(result: FavoritesResult): FavoritesState {
        return when(result) {
            FavoritesResult.Loading -> FavoritesState.LoadingState
            else -> throw IllegalStateException("unsupported")
        }
    }

}