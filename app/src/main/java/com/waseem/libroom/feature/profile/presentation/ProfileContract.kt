package com.waseem.libroom.feature.profile.presentation

import com.waseem.libroom.core.mvi.MviAction
import com.waseem.libroom.core.mvi.MviEvent
import com.waseem.libroom.core.mvi.MviResult
import com.waseem.libroom.core.mvi.MviStateReducer
import com.waseem.libroom.core.mvi.MviViewState

sealed class ProfileAction : MviAction {
    object SignOutClicked : ProfileAction()
}

sealed class ProfileResult : MviResult {
    object Loading : ProfileResult()
    object SignOutSuccess : ProfileResult()
    object SignOutFailure : ProfileResult()
}

sealed class ProfileEvent : MviEvent, ProfileResult()

sealed class ProfileState : MviViewState {
    object DefaultState : ProfileState()
    object LoadingState : ProfileState()
}

class ProfileStateReducer : MviStateReducer<ProfileState, ProfileResult> {
    override fun ProfileState.reduce(result: ProfileResult): ProfileState {
        return when (val previousState = this) {
            is ProfileState.DefaultState -> previousState + result
            is ProfileState.LoadingState -> previousState + result
        }
    }

    private operator fun ProfileState.DefaultState.plus(result: ProfileResult): ProfileState {
        return when (result) {
            ProfileResult.Loading -> ProfileState.LoadingState
            else -> throw IllegalStateException("Invalid result $result for state $this")
        }
    }

    private operator fun ProfileState.LoadingState.plus(result: ProfileResult): ProfileState {
        return when (result) {
            ProfileResult.SignOutSuccess -> ProfileState.DefaultState
            ProfileResult.SignOutFailure -> ProfileState.DefaultState
            else -> throw IllegalStateException("Invalid result $result for state $this")
        }
    }

}