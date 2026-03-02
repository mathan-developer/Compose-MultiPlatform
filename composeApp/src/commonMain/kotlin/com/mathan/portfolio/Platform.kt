package com.mathan.portfolio

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform