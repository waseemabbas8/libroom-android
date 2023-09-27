package com.waseem.libroom.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waseem.libroom.core.mvi.MviAction
import com.waseem.libroom.core.mvi.MviEvent
import com.waseem.libroom.core.mvi.MviResult
import com.waseem.libroom.core.mvi.MviStateReducer
import com.waseem.libroom.core.mvi.MviViewState
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.scan

abstract class BaseStateViewModel<Action : MviAction, Result : MviResult, Event : MviEvent, State : MviViewState, Reducer : MviStateReducer<State, Result>>(
    initialState: State,
    reducer: Reducer
) : ViewModel(), MviStateReducer<State, Result> by reducer {

    private val _fsmFlow = MutableSharedFlow<Action>(
        extraBufferCapacity = 20,
        onBufferOverflow = BufferOverflow.DROP_OLDEST // gotta use this in order to be able to use tryEmit function
    )

    private val _event = MutableSharedFlow<Event>(
        extraBufferCapacity = 20,
        onBufferOverflow = BufferOverflow.DROP_OLDEST // gotta use this in order to be able to use tryEmit function
    )
    val event: SharedFlow<Event> = _event

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state

    init {
        setupStateMachine()
    }

    @Suppress("UNCHECKED_CAST")
    private fun setupStateMachine() {
        _fsmFlow.onEach {  }
            .flatMapConcat { it.process() } //each action is transformed into a result
            .scan(_state.value) { previousState, result ->
                if (result is MviEvent) {
                    //The action has generated an event
                    _event.tryEmit(result as Event)
                    previousState
                } else {
                    previousState reduce result
                }
            }
            .onEach {
                //state has been changed
                _state.value = it
            }
            .launchIn(viewModelScope)
    }

    protected abstract fun Action.process(): Flow<Result>

    protected fun emitResult(result: Result) = flow { emit(result) }

    protected fun emitEvent(event: Event) = flow { emit(event) }

    fun action(action: Action) {
        _fsmFlow.tryEmit(action)
    }
}