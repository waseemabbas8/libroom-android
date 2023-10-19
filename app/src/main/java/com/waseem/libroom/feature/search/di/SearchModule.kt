package com.waseem.libroom.feature.search.di

import com.waseem.libroom.feature.author.domain.AuthorRepository
import com.waseem.libroom.feature.author.domain.GetTopAuthors
import com.waseem.libroom.feature.author.domain.GetTopAuthorsImpl
import com.waseem.libroom.feature.category.domain.CategoryRepository
import com.waseem.libroom.feature.category.domain.usecase.GetTopCategories
import com.waseem.libroom.feature.category.domain.usecase.GetTopCategoriesImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher

@InstallIn(ViewModelComponent::class)
@Module
object SearchModule {

    @Provides
    fun provideGetTopAuthors(authorRepository: AuthorRepository, dispatcher: CoroutineDispatcher): GetTopAuthors {
        return GetTopAuthorsImpl(authorRepository = authorRepository, dispatcher = dispatcher)
    }

    @Provides
    fun provideGetTopCategories(categoryRepository: CategoryRepository, dispatcher: CoroutineDispatcher): GetTopCategories {
        return GetTopCategoriesImpl(dispatcher = dispatcher, repository = categoryRepository)
    }
}