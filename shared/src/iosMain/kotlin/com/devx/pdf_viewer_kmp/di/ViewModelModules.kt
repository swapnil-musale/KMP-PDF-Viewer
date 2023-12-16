package com.devx.pdf_viewer_kmp.di

import com.devx.pdf_viewer_kmp.PdfViewModel
import org.koin.dsl.module

actual fun getViewModelByPlatform() = module {
    single {
        PdfViewModel()
    }
}
