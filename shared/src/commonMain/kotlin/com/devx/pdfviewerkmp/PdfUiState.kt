package com.devx.pdfviewerkmp

sealed interface PdfUiState {
    data class Success(val pdfData: ByteArray, val encodedBase64Data: String) : PdfUiState {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || this::class != other::class) return false

            other as Success

            if (!pdfData.contentEquals(other.pdfData)) return false
            return encodedBase64Data == other.encodedBase64Data
        }

        override fun hashCode(): Int {
            var result = pdfData.contentHashCode()
            result = 31 * result + encodedBase64Data.hashCode()
            return result
        }
    }

    data class Error(val exceptionMessage: String) : PdfUiState
    data object Loading : PdfUiState
    data object Uninitialized : PdfUiState
}
