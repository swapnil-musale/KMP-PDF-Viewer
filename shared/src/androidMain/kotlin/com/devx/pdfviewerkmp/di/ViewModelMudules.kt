package com.devx.pdfviewerkmp.di

import com.devx.pdfviewerkmp.PdfViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

actual fun getViewModelByPlatform() = module {
    viewModel {
        PdfViewModel(apiService = get())
    }
}
