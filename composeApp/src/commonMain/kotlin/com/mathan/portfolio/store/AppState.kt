package com.mathan.portfolio.store

import com.mathan.portfolio.models.Education
import com.mathan.portfolio.models.Experience
import com.mathan.portfolio.models.Project

enum class Screen {
    About, Skills, Work, Projects, Others
}

data class ContactInfo(
    val email: String,
    val phone: String,
    val linkedin: String,
    val github: String
)

data class AppState(
    val selectedScreen: Screen = Screen.About,
    val toastMessage: String? = null,
    val name: String = "Mathan Kumar",
    val role: String = "Senior Android Engineer",
    val location: String = "Bengaluru, Karnataka, India",
    val aboutSummary: String = "Senior Mobile Engineer building high-performance Android and Flutter apps using Kotlin, Jetpack Compose, Dart, and modern mobile architecture patterns.",
    val aboutBulletPoints: List<String> = listOf(
        "9+ years building high-performance Android and Flutter apps",
        "Published 15+ Android apps and 3 Flutter apps",
        "Strong in MVVM, Clean Architecture, modularization",
        "Production experience with Azure AI integrations"
    ),
    val contact: ContactInfo = ContactInfo(
        email = "gmathankumar93@gmail.com",
        phone = "+91 9629462900",
        linkedin = "LinkedIn",
        github = "GitHub"
    ),
    val skills: List<String> = listOf(
        "Android", "Kotlin", "Jetpack Compose", "Flutter", "Dart", "Coroutines", "Flow",
        "Redux Pattern", "Firebase", "Espresso", "UI Automator", "Architecture"
    ),
    val experiences: List<Experience> = listOf(
        Experience("Nov 2023 - Present", "Senior Android Engineer", "Presidio Solutions Pvt. Ltd", "Bengaluru, Karnataka, India"),
        Experience("Aug 2020 - Oct 2023", "Technical Lead", "Techjays Solutions Pvt. Ltd", "Remote, India"),
        Experience("Jun 2018 - Aug 2020", "Software Engineer", "Angler Technologies Pvt. Ltd", "Coimbatore, Tamilnadu, India"),
        Experience("Dec 2015 - May 2018", "Junior Software Engineer", "Schnell Energy Equipments Pvt. Ltd", "Coimbatore, Tamilnadu, India")
    ),
    val projects: List<Project> = listOf(
        Project("1", "DraftKings Casino", "Online casino platform"),
        Project("2", "DraftKings Sportsbook", "Sports betting platform"),
        Project("3", "DraftKings Jackpocket", "Lottery ticket platform"),
        Project("4", "DraftKings Predictions", "Sports prediction game"),
        Project("5", "Fayvit", "Social media platform for travel")
    ),
    val certifications: List<String> = listOf("Microsoft Certified Azure AI Engineer (AI-102)"),
    val education: List<Education> = listOf(
        Education("Bachelor of Engineering", "Electrical Engineering", "Bannari Amman Institute of Technology", "Erode, India", "2012 - 2015"),
        Education("Diploma in Engineering", "Electrical Engineering", "PSG College of Technology", "Coimbatore, India", "2009 - 2012")
    )
)
