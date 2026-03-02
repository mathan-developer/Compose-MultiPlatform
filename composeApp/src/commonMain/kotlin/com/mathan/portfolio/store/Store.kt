package com.mathan.portfolio.store

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Minimal Redux-like Store for Compose Multiplatform sample.
 *
 * Improvements over the simple implementation:
 * - Actions are processed sequentially on an internal coroutine using a Channel (avoids races).
 * - Provides a non-suspending `dispatch` and a suspending `dispatchBlocking` API.
 * - Exposes `close()` to clean up resources.
 *
 * This implementation intentionally keeps the reducer synchronous and pure. Side-effects
 * (network, DB) should be executed by repo/viewmodel code which then dispatches result actions.
 */
class Store<State, Action>(
    initialState: State,
    private val reducer: (State, Action) -> State,
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.Default)
) {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State> get() = _state

    // Unbounded channel to buffer dispatched actions; processed sequentially by `processorJob`.
    private val actions = Channel<Action>(Channel.UNLIMITED)

    private val processorJob = scope.launch {
        for (action in actions) {
            try {
                val newState = reducer(_state.value, action)
                _state.value = newState
            } catch (_: Throwable) {
                // Swallow errors in reducer to avoid crashing the processor loop in production.
                // In development you may want to log or rethrow.
            }
        }
    }

    /**
     * Enqueue an action for processing. This is non-blocking.
     */
    fun dispatch(action: Action) {
        actions.trySend(action)
    }

    /**
     * Send an action and suspend until it's accepted by the channel (rarely needed).
     */
    suspend fun dispatchBlocking(action: Action) {
        actions.send(action)
    }

    /**
     * Close the store and cancel internal processing. After calling this the store will not
     * accept new actions.
     */
    fun close() {
        actions.close()
        processorJob.cancel()
    }
}
