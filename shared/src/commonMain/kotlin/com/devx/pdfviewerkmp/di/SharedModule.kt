package com.devx.pdfviewerkmp.di

private val sharedModules = listOf(getViewModelByPlatform(), getNetworkModule())

fun getSharedModules() = sharedModules
