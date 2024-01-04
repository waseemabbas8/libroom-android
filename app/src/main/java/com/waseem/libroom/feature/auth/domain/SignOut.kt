package com.waseem.libroom.feature.auth.domain

import com.waseem.libroom.core.usecase.NoParams
import com.waseem.libroom.core.usecase.UseCase

interface SignOut : UseCase<Boolean, NoParams>

class SignOutImpl(
    private val authRepository: AuthRepository
) : SignOut {
    override suspend fun invoke(params: NoParams): Result<Boolean> {
        return authRepository.signOut()
    }
}