package com.devx.pdf_viewer_kmp.android

import android.app.Application
import com.devx.pdf_viewer_kmp.di.getSharedModules
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(modules = getSharedModules())
        }
    }
}
