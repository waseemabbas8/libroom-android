package com.waseem.libroom.core.di

import com.waseem.libroom.feature.author.data.AuthorRepositoryImpl
import com.waseem.libroom.feature.author.domain.AuthorRepository
import com.waseem.libroom.feature.book.data.BookRepositoryImpl
import com.waseem.libroom.feature.book.domain.BookRepository
import com.waseem.libroom.feature.category.data.CategoryRepositoryImpl
import com.waseem.libroom.feature.category.domain.CategoryRepository
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
    fun provideCategoryRepository(): CategoryRepository {
        return CategoryRepositoryImpl()
    }
}