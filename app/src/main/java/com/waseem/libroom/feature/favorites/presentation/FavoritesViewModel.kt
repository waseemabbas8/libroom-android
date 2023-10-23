package com.waseem.libroom.feature.favorites.presentation

import com.waseem.libroom.core.BaseStateViewModel
import com.waseem.libroom.feature.favorites.domain.usecase.GetFavoriteBooks
import com.waseem.libroom.feature.home.presentation.toBooksListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavorites: GetFavoriteBooks,
    reducer: FavoriteReducer
) : BaseStateViewModel<FavoritesAction, FavoritesResult, FavoritesEvent, FavoritesState, FavoriteReducer>(
    initialState = FavoritesState.DefaultState,
    reducer = reducer
) {

    init {
        action(FavoritesAction.Load)
    }

    override fun FavoritesAction.process(): Flow<FavoritesResult> {
        return when (this) {
            FavoritesAction.BookItemClicked -> TODO()
            FavoritesAction.Load -> loadFavoriteBooks()
        }
    }

    private fun loadFavoriteBooks(): Flow<FavoritesResult> {
        return flow<FavoritesResult> {
            getFavorites(params = GetFavoriteBooks.Params(userId = UUID.randomUUID().toString()))
                .onSuccess { books ->
                    emit(
                        FavoritesResult.FavoriteBooks(
                            uiState = FavoritesUiState(
                                searchBoxValue = "",
                                favoriteBooks = books.map { it.toBooksListUiState() },
                            )
                        )
                    )
                }.onFailure {
                    throw IllegalStateException("Something has gone wrong!")
                }
        }.onStart {
            emit(FavoritesResult.Loading)
        }.catch {
            emit(FavoritesResult.Failure)
        }
    }
}