package com.devx.pdf_viewer_kmp.utils

import com.devx.pdf_viewer_kmp.PdfViewModel
import com.devx.pdf_viewer_kmp.di.getSharedModules
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(modules = getSharedModules())
    }
}

class KoinHelper : KoinComponent {
    fun getPdfViewModel() = get<PdfViewModel>()
}
