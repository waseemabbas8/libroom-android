package com.waseem.libroom.feature.auth.domain

import com.waseem.libroom.core.SResult
import com.waseem.libroom.core.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

interface SignInWithEmailPassword : UseCase<User, SignInWithEmailPassword.Params> {
    data class Params(val email: String, val password: String)
}

class SignInWithEmailPasswordImpl(
    private val dispatcher: CoroutineDispatcher,
    private val authRepository: AuthRepository
) : SignInWithEmailPassword {
    override suspend fun invoke(params: SignInWithEmailPassword.Params): SResult<User> {
        return withContext(dispatcher) {
            authRepository.signIn(params.email, params.password)
        }
    }
}