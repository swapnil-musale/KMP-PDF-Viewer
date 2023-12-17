package com.devx.pdf_viewer_kmp

import com.devx.pdf_viewer_kmp.network.ApiService
import dev.icerock.moko.mvvm.flow.cMutableStateFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PdfViewModel(private val apiService: ApiService) : ViewModel() {

    private val _uiState =
        MutableStateFlow<PdfUiState>(PdfUiState.Uninitialized).cMutableStateFlow()
    val uiState = _uiState.asStateFlow().cStateFlow()

    fun downloadPDF() {
        _uiState.value = PdfUiState.Loading
        viewModelScope.launch {
            try {
                val response = apiService.getPdfData()
                _uiState.value = PdfUiState.Success(pdfData = response)
            } catch (e: Exception) {
                _uiState.value = PdfUiState.Error(exceptionMessage = e.message.orEmpty())
            }
        }
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}
