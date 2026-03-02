package com.mathan.portfolio.store

import com.mathan.portfolio.models.Project

sealed class AppAction {
    data class SelectScreen(val screen: Screen) : AppAction()
    data class ShowToast(val message: String?) : AppAction()
    object LoadProjects : AppAction()
    data class ProjectsLoaded(val projects: List<Project>) : AppAction()
    data class ProjectsLoadFailed(val error: String) : AppAction()
}
