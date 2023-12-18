package com.devx.pdfviewerkmp.di

import com.devx.pdfviewerkmp.network.ApiService
import com.devx.pdfviewerkmp.network.httpClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

fun getNetworkModule() = module {
    single<HttpClient> {
        httpClient
    }

    single<ApiService> {
        ApiService(httpClient = get())
    }
}
