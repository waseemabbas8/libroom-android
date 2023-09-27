package com.waseem.libroom.core.mvi

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.waseem.libroom.core.BaseStateViewModel
import kotlinx.coroutines.flow.StateFlow

/**
 * @author Ryan Simon
 */
/**
 * Observe [BaseStateViewModel.event] in a Compose [LaunchedEffect].
 * @param lifecycleState [Lifecycle.State] in which [lifecycleState] block runs.
 */
@SuppressLint("ComposableNaming")
@Composable
fun <CustomAction : MviAction, CustomResult : MviResult, CustomEvent : MviEvent,
        CustomState : MviViewState, CustomReducer : MviStateReducer<CustomState, CustomResult>>
        BaseStateViewModel<CustomAction, CustomResult, CustomEvent,
                CustomState, CustomReducer>.collectEvents(
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
    eventHandler: (suspend (event: CustomEvent) -> Unit)
) {
    val eventFlow = this.event
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(eventFlow, lifecycleOwner) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(lifecycleState) {
            eventFlow.collect {
                eventHandler(it)
            }
        }
    }
}

/**
 * Observe [BaseStateViewModel.state] as [State].
 * @param lifecycleState The Lifecycle where the restarting collecting from this flow work will be kept alive.
 */
@Composable
fun <CustomAction : MviAction, CustomResult : MviResult, CustomEvent : MviEvent,
        CustomState : MviViewState, CustomReducer : MviStateReducer<CustomState, CustomResult>>
        BaseStateViewModel<CustomAction, CustomResult, CustomEvent,
                CustomState, CustomReducer>.collectState(
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED
): State<CustomState> {
    return this.state.collectState(lifecycleState = lifecycleState)
}

@Composable
private fun <T> StateFlow<T>.collectState(
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED
): State<T> {
    val lifecycleOwner = LocalLifecycleOwner.current

    val stateFlowLifecycleAware = remember(this, lifecycleOwner) {
        this.flowWithLifecycle(lifecycleOwner.lifecycle, lifecycleState)
    }

    // Need to access the initial value to convert to State - collectAsState() suppresses this lint warning too
    @SuppressLint("StateFlowValueCalledInComposition")
    val initialValue = this.value
    return stateFlowLifecycleAware.collectAsState(initialValue)
}