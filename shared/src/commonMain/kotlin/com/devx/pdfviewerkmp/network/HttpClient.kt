package com.devx.pdfviewerkmp.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json

val httpClient = HttpClient {
    defaultRequest {
        url("https://file-examples.com/storage/fe3666494365908ae9beb40/2017/10/")
    }
    install(ContentNegotiation) {
        json()
    }
}
