package com.mathan.portfolio.store

fun appReducer(state: AppState, action: AppAction): AppState {
    return when (action) {
        is AppAction.SelectScreen -> state.copy(selectedScreen = action.screen)
        is AppAction.ShowToast -> state.copy(toastMessage = action.message)
        is AppAction.LoadProjects -> state
        is AppAction.ProjectsLoaded -> state.copy(projects = action.projects)
        is AppAction.ProjectsLoadFailed -> state
    }
}
