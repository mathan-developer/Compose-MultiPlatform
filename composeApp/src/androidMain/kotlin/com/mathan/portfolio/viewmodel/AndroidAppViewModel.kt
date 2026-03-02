package com.mathan.portfolio.viewmodel

import com.mathan.portfolio.store.AppAction
import com.mathan.portfolio.store.AppState
import com.mathan.portfolio.store.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidAppViewModel @Inject constructor(
    store: Store<AppState, AppAction>
) : AppViewModel(store)
