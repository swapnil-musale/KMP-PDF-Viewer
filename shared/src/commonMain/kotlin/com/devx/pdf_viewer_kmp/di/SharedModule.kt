package com.devx.pdf_viewer_kmp.di

private val sharedModules = listOf(getViewModelByPlatform())

fun getSharedModules() = sharedModules