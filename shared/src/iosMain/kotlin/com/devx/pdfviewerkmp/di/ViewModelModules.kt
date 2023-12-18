package com.devx.pdfviewerkmp.di

import com.devx.pdfviewerkmp.PdfViewModel
import org.koin.dsl.module

actual fun getViewModelByPlatform() = module {
    single {
        PdfViewModel(apiService = get())
    }
}
