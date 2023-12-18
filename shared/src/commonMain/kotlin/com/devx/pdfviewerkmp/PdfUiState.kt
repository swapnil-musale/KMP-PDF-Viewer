package com.devx.pdfviewerkmp

sealed interface PdfUiState {
    data class Success(val pdfData: ByteArray) : PdfUiState
    data class Error(val exceptionMessage: String) : PdfUiState
    data object Loading : PdfUiState
    data object Uninitialized : PdfUiState
}
