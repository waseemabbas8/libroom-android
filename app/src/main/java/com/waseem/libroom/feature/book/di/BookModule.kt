package com.waseem.libroom.feature.book.di

import com.waseem.libroom.feature.book.domain.BookRepository
import com.waseem.libroom.feature.favorites.domain.usecase.GetFavoriteBooks
import com.waseem.libroom.feature.favorites.domain.usecase.GetFavoriteBooksImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher

@InstallIn(ViewModelComponent::class)
@Module
object BookModule {

    @Provides
    fun providesGetFavoriteBooks(dispatcher: CoroutineDispatcher, repository: BookRepository): GetFavoriteBooks {
        return GetFavoriteBooksImpl(dispatcher = dispatcher, repository = repository)
    }
}