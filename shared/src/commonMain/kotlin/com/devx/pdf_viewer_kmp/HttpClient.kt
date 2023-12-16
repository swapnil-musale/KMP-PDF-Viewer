package com.devx.pdf_viewer_kmp

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

val httpClient = HttpClient {
    install(ContentNegotiation) {
        json()
    }
}
