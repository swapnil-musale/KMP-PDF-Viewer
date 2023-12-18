package com.devx.pdfviewerkmp.utils

import com.devx.pdfviewerkmp.PdfViewModel
import com.devx.pdfviewerkmp.di.getSharedModules
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
