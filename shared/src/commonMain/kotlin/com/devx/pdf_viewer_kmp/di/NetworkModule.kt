package com.devx.pdf_viewer_kmp.di

import com.devx.pdf_viewer_kmp.network.ApiService
import com.devx.pdf_viewer_kmp.network.httpClient
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
