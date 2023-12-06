package com.waseem.libroom.feature.onboarding.presentation

import com.waseem.libroom.core.BaseStateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    reducer: OnboardingReducer
) : BaseStateViewModel<OnboardingAction, OnboardingResult, OnboardingEvent, OnboardingState, OnboardingReducer>(
    initialState = OnboardingState.Default,
    reducer = reducer
) {
    override fun OnboardingAction.process(): Flow<OnboardingResult> {
        return when(this) {
            OnboardingAction.OnNext -> {
                if (state.value.uiState.currentStep == state.value.uiState.pages.lastIndex) {
                    emitEvent(OnboardingEvent.GotoAuth)
                } else {
                   val nextPage = state.value.uiState.currentStep + 1
                    emitResult(OnboardingResult.CurrentPage(index = nextPage))
                }
            }
            OnboardingAction.OnSkip -> {
                emitEvent(OnboardingEvent.GotoAuth)
            }
        }
    }

}