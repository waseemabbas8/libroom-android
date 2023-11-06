package com.waseem.libroom.feature.home.presentation

import com.waseem.libroom.core.BaseStateViewModel
import com.waseem.libroom.core.usecase.NoParams
import com.waseem.libroom.feature.home.domain.GetHomeContent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeContent: GetHomeContent,
    reducer: HomeReducer,
) : BaseStateViewModel<HomeAction, HomeResult, HomeEvent, HomeState, HomeReducer>(
    initialState = HomeState.DefaultState,
    reducer = reducer
) {

    init {
        action(HomeAction.Load)
    }

    override fun HomeAction.process(): Flow<HomeResult> {
        return when(this) {
            HomeAction.Load -> loadHomeContent()
            HomeAction.ViewAllClicked -> TODO()
            is HomeAction.BookItemClicked -> emitEvent(
                event = HomeEvent.NavigateToBookDetail(bookId = bookId)
            )
        }
    }

    private fun loadHomeContent(): Flow<HomeResult> {
        return flow<HomeResult> {
            getHomeContent(params = NoParams)
                .onSuccess {
                    emit(HomeResult.HomeContent(it.toUiState()))
                }.onFailure {
                    throw IllegalStateException("Something has gone wrong!")
                }
        }.onStart {
            emit(HomeResult.Loading)
        }.catch {
            emit(HomeResult.Failure)
        }
    }

}