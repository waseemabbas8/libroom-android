package com.waseem.libroom.core.di

import com.waseem.libroom.feature.author.data.AuthorRepositoryImpl
import com.waseem.libroom.feature.author.domain.AuthorRepository
import com.waseem.libroom.feature.author.domain.GetTopAuthors
import com.waseem.libroom.feature.author.domain.GetTopAuthorsImpl
import com.waseem.libroom.feature.book.data.BookRepositoryImpl
import com.waseem.libroom.feature.book.domain.BookRepository
import com.waseem.libroom.feature.home.domain.GetHomeContent
import com.waseem.libroom.feature.home.domain.GetHomeContentImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideDispatcher(): CoroutineDispatcher {
        return Dispatchers.Default
    }

    @Provides
    fun provideBookRepository(): BookRepository {
        return BookRepositoryImpl()
    }

    @Provides
    fun provideAuthRepository(): AuthorRepository {
        return AuthorRepositoryImpl()
    }

    @Provides
    fun provideGetHomeContent(bookRepository: BookRepository, dispatcher: CoroutineDispatcher): GetHomeContent {
        return GetHomeContentImpl(bookRepository = bookRepository, dispatcher = dispatcher)
    }

    @Provides
    fun provideGetTopAuthors(authorRepository: AuthorRepository, dispatcher: CoroutineDispatcher): GetTopAuthors {
        return GetTopAuthorsImpl(authorRepository = authorRepository, dispatcher = dispatcher)
    }
}