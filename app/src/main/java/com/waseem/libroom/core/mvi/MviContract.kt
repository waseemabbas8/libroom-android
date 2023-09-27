package com.waseem.libroom.core.mvi


/**
 * A [MviAction] is the equivalent to Intent in traditional MVI architecture. We chose Action
 * as an alternative to avoid clashing with Android's prevalent Intent concept.
 *
 * When a user takes action via the UI, the [MviAction] represents the user's intent and it's
 * typically the first part of the state machine.
 */
interface MviAction

/**
 * [MviResult] represents the resulting effects of whatever was triggered by some [MviAction].
 * Typically a [MviResult] encapsulates some data from a repository, or a failure to fetch data.
 *
 * Additionally, a [MviResult] is required in order to trigger a state change and transition to the
 * next [MviViewState].
 */
interface MviResult

/**
 * [MviEvent] is a special kind of [MviResult]. It does not change state, instead, it represents a
 * side effect that happens as a result of a [MviAction].
 *
 * We use [MviEvent] most commonly to send navigation updates to the UI, show dialogs, snackbars,
 * and other transient pieces of UI that are not tied to [MviViewState].
 */
interface MviEvent : MviResult

/**
 * [MviViewState] represents the current state of the view. Typically, it encapsulates several
 * pieces of data required for the UI to render itself.
 *
 * The [MviViewState] can only be changed by processing a previous [MviViewState] plus a
 * [MviResult] using the appropriate [MviStateReducer].
 */
interface MviViewState

/**
 * The job of the [MviStateReducer] is to take a [MviResult] paired with a [MviViewState] and figure
 * out what the next state in the state machine should be.
 *
 * For example, DefaultState reduce DataSuccessResult = LoadedState
 */
interface MviStateReducer<S : MviViewState, R : MviResult> {
    infix fun S.reduce(result: R): S
}
