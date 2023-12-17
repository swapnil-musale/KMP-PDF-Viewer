package com.devx.pdf_viewer_kmp

sealed interface PdfUiState {
    data class Success(val pdfData: ByteArray) : PdfUiState
    data class Error(val exceptionMessage: String) : PdfUiState
    data object Loading : PdfUiState
    data object Uninitialized : PdfUiState
}
