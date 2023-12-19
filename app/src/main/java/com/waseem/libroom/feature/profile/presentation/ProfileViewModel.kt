package com.waseem.libroom.feature.profile.presentation

import com.waseem.libroom.core.BaseStateViewModel
import com.waseem.libroom.core.usecase.NoParams
import com.waseem.libroom.feature.auth.domain.SignOut
import com.waseem.libroom.feature.root.domain.AuthState
import com.waseem.libroom.feature.root.domain.UpdateAuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val signOut: SignOut,
    private val updateAuthState: UpdateAuthState
) : BaseStateViewModel<ProfileAction, ProfileResult, ProfileEvent, ProfileState, ProfileStateReducer>(
    initialState = ProfileState.DefaultState,
    reducer = ProfileStateReducer()
) {
    override fun ProfileAction.process(): Flow<ProfileResult> {
        return when(this) {
            ProfileAction.SignOutClicked -> flow<ProfileResult> {
                signOut(NoParams)
                updateAuthState(params = UpdateAuthState.Params(AuthState.UNAUTHENTICATED))
                emit(ProfileResult.SignOutSuccess)
            }.onStart {
                emit(ProfileResult.Loading)
            }.catch {
                emit(ProfileResult.SignOutFailure)
            }
        }
    }

}