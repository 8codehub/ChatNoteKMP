package com.chatnote

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform