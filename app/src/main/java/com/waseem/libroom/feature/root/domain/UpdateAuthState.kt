package com.waseem.libroom.feature.root.domain

import com.waseem.libroom.core.SResult
import com.waseem.libroom.core.usecase.UseCase

interface UpdateAuthState : UseCase<Unit, UpdateAuthState.Params> {
    data class Params(val authState: AuthState)
}

class UpdateAuthStateImpl(
    private val userPreferenceRepository: UserPreferenceRepository
) : UpdateAuthState {
    override suspend fun invoke(params: UpdateAuthState.Params): SResult<Unit> {
        return SResult.success(userPreferenceRepository.setAuthState(params.authState))
    }
}