package com.devx.pdfviewerkmp.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService(private val httpClient: HttpClient) {

    suspend fun getPdfData(): ByteArray {
        return httpClient.get("file-example_PDF_1MB.pdf").body<ByteArray>()
    }
}
