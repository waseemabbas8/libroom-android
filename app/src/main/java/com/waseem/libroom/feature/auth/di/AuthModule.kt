package com.waseem.libroom.feature.auth.di

import com.google.firebase.auth.FirebaseAuth
import com.waseem.libroom.feature.auth.data.AuthRepositoryImpl
import com.waseem.libroom.feature.auth.domain.AuthRepository
import com.waseem.libroom.feature.auth.domain.SignInWithEmailPassword
import com.waseem.libroom.feature.auth.domain.SignInWithEmailPasswordImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher

@InstallIn(ViewModelComponent::class)
@Module
object AuthModule {

    @Provides
    fun provideAuthRepository(firebaseAuth: FirebaseAuth): AuthRepository {
        return AuthRepositoryImpl(firebaseAuth = firebaseAuth)
    }

    @Provides
    fun provideSignInWithEmailAndPassword(
        dispatcher: CoroutineDispatcher,
        authRepository: AuthRepository
    ): SignInWithEmailPassword {
        return SignInWithEmailPasswordImpl(dispatcher = dispatcher, authRepository = authRepository)
    }

}