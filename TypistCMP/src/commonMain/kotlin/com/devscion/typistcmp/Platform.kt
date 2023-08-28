package com.devscion.typistcmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform