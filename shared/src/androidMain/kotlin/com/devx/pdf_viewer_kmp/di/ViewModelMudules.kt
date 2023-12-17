package com.devx.pdf_viewer_kmp.di

import com.devx.pdf_viewer_kmp.PdfViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

actual fun getViewModelByPlatform() = module {
    viewModel {
        PdfViewModel(apiService = get())
    }
}
