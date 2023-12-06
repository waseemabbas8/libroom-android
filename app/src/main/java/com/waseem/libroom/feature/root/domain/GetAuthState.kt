package com.waseem.libroom.feature.root.domain

import com.waseem.libroom.core.usecase.NoParams
import com.waseem.libroom.core.usecase.ObservableUseCase

interface GetAuthState : ObservableUseCase<AuthState, NoParams>

class GetAuthStateImpl(
    private val userPreferenceRepository: UserPreferenceRepository
) : GetAuthState {
    override fun invoke(params: NoParams) = userPreferenceRepository.getAuthState()
}