package com.waseem.libroom.feature.home.presentation

import com.waseem.libroom.core.mvi.MviAction
import com.waseem.libroom.core.mvi.MviEvent
import com.waseem.libroom.core.mvi.MviResult
import com.waseem.libroom.core.mvi.MviStateReducer
import com.waseem.libroom.core.mvi.MviViewState
import javax.inject.Inject

sealed class HomeAction : MviAction {
    object Load : HomeAction()
    object ViewAllClicked : HomeAction()
    data class BookItemClicked(val bookId: String) : HomeAction()
}

sealed class HomeResult : MviResult {
    object Loading: HomeResult()
    data class HomeContent(val homeUiState: HomeUiState) : HomeResult()
    object Failure : HomeResult()
}

sealed class HomeEvent : MviEvent, HomeResult() {
    object NavigateToBooksList : HomeEvent()
    data class NavigateToBookDetail(val bookId: String): HomeEvent()
}

sealed class HomeState : MviViewState {
    object DefaultState : HomeState()
    object LoadingState: HomeState()
    data class HomeContentState(val uiState: HomeUiState) : HomeState()
    object ErrorState : HomeState()
}

class HomeReducer @Inject constructor() : MviStateReducer<HomeState, HomeResult> {
    override fun HomeState.reduce(result: HomeResult): HomeState {
        return when(val previousState = this) {
            is HomeState.DefaultState -> previousState + result
            is HomeState.ErrorState -> previousState + result
            is HomeState.HomeContentState -> previousState + result
            is HomeState.LoadingState -> previousState + result
        }
    }

    private operator fun HomeState.DefaultState.plus(result: HomeResult): HomeState {
        return when(result) {
            HomeResult.Loading -> HomeState.LoadingState
            else -> throw IllegalStateException("unsupported")
        }
    }

    private operator fun HomeState.LoadingState.plus(result: HomeResult): HomeState {
        return when(result) {
            HomeResult.Loading -> HomeState.LoadingState
            is HomeResult.HomeContent -> HomeState.HomeContentState(uiState = result.homeUiState)
            HomeResult.Failure -> HomeState.ErrorState
            else -> throw IllegalStateException("unsupported")
        }
    }

    private operator fun HomeState.ErrorState.plus(result: HomeResult): HomeState {
        return when(result) {
            HomeResult.Loading -> HomeState.LoadingState
            else -> throw IllegalStateException("unsupported")
        }
    }

    private operator fun HomeState.HomeContentState.plus(result: HomeResult): HomeState {
        return when(result) {
            HomeResult.Loading -> HomeState.LoadingState
            is HomeResult.HomeContent -> HomeState.HomeContentState(uiState = result.homeUiState)
            else -> throw IllegalStateException("unsupported")
        }
    }
}