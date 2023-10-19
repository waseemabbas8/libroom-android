package com.waseem.libroom.feature.home.di

import com.waseem.libroom.feature.book.domain.BookRepository
import com.waseem.libroom.feature.home.domain.GetHomeContent
import com.waseem.libroom.feature.home.domain.GetHomeContentImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher

@InstallIn(ViewModelComponent::class)
@Module
object HomeModule {

    @Provides
    fun provideGetHomeContent(bookRepository: BookRepository, dispatcher: CoroutineDispatcher): GetHomeContent {
        return GetHomeContentImpl(bookRepository = bookRepository, dispatcher = dispatcher)
    }
}