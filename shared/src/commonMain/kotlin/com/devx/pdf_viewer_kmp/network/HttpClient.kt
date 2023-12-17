package com.devx.pdf_viewer_kmp.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json

val httpClient = HttpClient {
    defaultRequest {
        url("https://www.clickdimensions.com/links/")
    }
    install(ContentNegotiation) {
        json()
    }
}
