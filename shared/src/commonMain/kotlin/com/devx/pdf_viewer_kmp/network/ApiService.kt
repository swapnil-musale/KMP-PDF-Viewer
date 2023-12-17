package com.devx.pdf_viewer_kmp.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService(private val httpClient: HttpClient) {

    suspend fun getPdfData(): ByteArray {
        return httpClient.get("TestPDFfile.pdf").body<ByteArray>()
    }
}
