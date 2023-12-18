package com.devx.pdfviewerkmp.android

import android.app.Application
import com.devx.pdfviewerkmp.di.getSharedModules
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(modules = getSharedModules())
        }
    }
}
