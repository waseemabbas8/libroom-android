package com.waseem.libroom.feature.root.domain

import com.waseem.libroom.core.usecase.UseCase

interface UpdateAuthState : UseCase<Unit, UpdateAuthState.Params> {
    data class Params(val authState: AuthState)
}

class UpdateAuthStateImpl(
    private val userPreferenceRepository: UserPreferenceRepository
) : UpdateAuthState {
    override suspend fun invoke(params: UpdateAuthState.Params): Result<Unit> {
        return Result.success(userPreferenceRepository.setAuthState(params.authState))
    }
}