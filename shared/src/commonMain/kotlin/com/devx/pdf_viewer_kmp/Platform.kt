package com.devx.pdf_viewer_kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform