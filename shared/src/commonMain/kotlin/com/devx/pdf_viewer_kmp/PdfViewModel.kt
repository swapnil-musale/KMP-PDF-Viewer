package com.devx.pdf_viewer_kmp

import dev.icerock.moko.mvvm.flow.cMutableStateFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PdfViewModel : ViewModel() {

    private val _pdfData = MutableStateFlow<ByteArray?>(null).cMutableStateFlow()
    val pdfData = _pdfData.asStateFlow().cStateFlow()

    fun downloadPDF() {
        viewModelScope.launch {
            val response = httpClient
                .get("https://www.clickdimensions.com/links/TestPDFfile.pdf")
                .body<ByteArray>()

            _pdfData.value = response
        }
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}
