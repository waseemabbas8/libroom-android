package com.waseem.libroom.core.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.waseem.libroom.feature.author.data.AuthorRepositoryImpl
import com.waseem.libroom.feature.author.domain.AuthorRepository
import com.waseem.libroom.feature.book.data.BookRepositoryImpl
import com.waseem.libroom.feature.book.domain.BookRepository
import com.waseem.libroom.feature.category.data.CategoryRepositoryImpl
import com.waseem.libroom.feature.category.domain.CategoryRepository
import com.waseem.libroom.feature.root.data.UserPreferenceRepositoryImpl
import com.waseem.libroom.feature.root.domain.GetAuthState
import com.waseem.libroom.feature.root.domain.GetAuthStateImpl
import com.waseem.libroom.feature.root.domain.UpdateAuthState
import com.waseem.libroom.feature.root.domain.UpdateAuthStateImpl
import com.waseem.libroom.feature.root.domain.UserPreferenceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

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

    @Provides
    @Singleton
    fun providePreferenceDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create {
            context.preferencesDataStoreFile("user_prefs")
        }
    }

    @Provides
    @Singleton
    fun provideUserPreferenceRepository(dataStore: DataStore<Preferences>): UserPreferenceRepository {
        return UserPreferenceRepositoryImpl(dataStore)
    }

    @Provides
    fun provideGetAuthState(userPreferenceRepository: UserPreferenceRepository): GetAuthState {
        return GetAuthStateImpl(userPreferenceRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateAuthState(userPreferenceRepository: UserPreferenceRepository): UpdateAuthState {
        return UpdateAuthStateImpl(userPreferenceRepository)
    }
}