package com.mathan.portfolio

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Android-specific App entry that provides a lifecycle-aware holder for the shared AppViewModel.
 * This ensures the underlying Store is closed when the Android ViewModel is cleared.
 */
class AndroidAppViewModelHolder(val appViewModel: com.mathan.portfolio.viewmodel.AppViewModel) : ViewModel() {
    override fun onCleared() {
        try {
            appViewModel.close()
        } catch (_: Throwable) {
        }
        super.onCleared()
    }
}

object AndroidAppViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return AndroidAppViewModelHolder(com.mathan.portfolio.viewmodel.AppViewModel()) as T
    }
}

@Composable
actual fun App() {
    val holder: AndroidAppViewModelHolder = viewModel(factory = AndroidAppViewModelFactory)
    AppContent(viewModel = holder.appViewModel)
}
