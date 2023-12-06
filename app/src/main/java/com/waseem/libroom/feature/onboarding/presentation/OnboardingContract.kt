package com.waseem.libroom.feature.onboarding.presentation

import com.waseem.libroom.core.mvi.MviAction
import com.waseem.libroom.core.mvi.MviEvent
import com.waseem.libroom.core.mvi.MviResult
import com.waseem.libroom.core.mvi.MviStateReducer
import com.waseem.libroom.core.mvi.MviViewState
import javax.inject.Inject

sealed class OnboardingAction : MviAction {
    object OnNext : OnboardingAction()

    object OnSkip : OnboardingAction()
}

sealed class OnboardingResult : MviResult {
    data class CurrentPage(val index: Int) : OnboardingResult()
}

sealed class OnboardingEvent : MviEvent, OnboardingResult() {
    object GotoAuth : OnboardingEvent()
}

sealed class OnboardingState(val uiState: OnboardingUiState) : MviViewState {
    object Default : OnboardingState(uiState = OnboardingUiState())
    data class CurrentPageState(val index: Int) : OnboardingState(uiState = OnboardingUiState(currentStep = index))
}

class OnboardingReducer @Inject constructor() : MviStateReducer<OnboardingState, OnboardingResult> {
    override fun OnboardingState.reduce(result: OnboardingResult): OnboardingState {
        return when (val previousState = this) {
            is OnboardingState.Default -> previousState + result
            is OnboardingState.CurrentPageState -> previousState + result
        }
    }

    private operator fun OnboardingState.Default.plus(result: OnboardingResult): OnboardingState {
        return when (result) {
            is OnboardingResult.CurrentPage -> OnboardingState.CurrentPageState(index = result.index)
            else -> throw IllegalStateException("Unknown result $result")
        }
    }

    private operator fun OnboardingState.CurrentPageState.plus(result: OnboardingResult): OnboardingState {
        return when (result) {
            is OnboardingResult.CurrentPage -> OnboardingState.CurrentPageState(index = result.index)
            else -> throw IllegalStateException("Unknown result $result")
        }
    }
}