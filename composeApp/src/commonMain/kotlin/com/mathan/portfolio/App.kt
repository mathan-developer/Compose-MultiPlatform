package com.mathan.portfolio

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.mathan.portfolio.screens.HomeScreen
import com.mathan.portfolio.viewmodel.AppViewModel

@Composable
expect fun App()

@Composable
fun AppContent(viewModel: AppViewModel = AppViewModel()) {
    MaterialTheme {
        HomeScreen(viewModel = viewModel)
    }
}
