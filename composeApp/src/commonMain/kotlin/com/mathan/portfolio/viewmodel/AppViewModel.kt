package com.mathan.portfolio.viewmodel

import androidx.lifecycle.ViewModel
import com.mathan.portfolio.store.AppAction
import com.mathan.portfolio.store.AppState
import com.mathan.portfolio.store.Screen
import com.mathan.portfolio.store.Store
import com.mathan.portfolio.store.appReducer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow

open class AppViewModel(
    private val store: Store<AppState, AppAction> = Store(AppState(), ::appReducer,
        CoroutineScope(Dispatchers.Main))
) : ViewModel() {
    val state: StateFlow<AppState> = store.state

    fun selectScreen(screen: Screen) {
        store.dispatch(AppAction.SelectScreen(screen))
    }

    fun showToast(message: String) {
        store.dispatch(AppAction.ShowToast(message))
    }

    fun clearToast() {
        store.dispatch(AppAction.ShowToast(null))
    }

    fun close() {
        store.close()
    }

    override fun onCleared() {
        super.onCleared()
        try {
            close()
        } catch (_: Throwable) {
            // ignore
        }
    }
}
