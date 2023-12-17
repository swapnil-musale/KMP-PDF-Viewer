package com.devx.pdf_viewer_kmp.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.devx.pdf_viewer_kmp.PdfUiState
import com.devx.pdf_viewer_kmp.PdfViewModel
import com.devx.pdf_viewer_kmp.android.theme.AppTheme
import com.rizzi.bouquet.ResourceType
import com.rizzi.bouquet.VerticalPDFReader
import com.rizzi.bouquet.rememberVerticalPdfReaderState
import org.koin.androidx.compose.getViewModel
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
@Composable
fun PdfViewerScreen() {
    AppTheme {
        val pdfViewModel: PdfViewModel = getViewModel()
        val uiState by pdfViewModel.uiState.collectAsState()

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            when (uiState) {
                is PdfUiState.Uninitialized -> {
                    Button(onClick = {
                        pdfViewModel.downloadPDF()
                    }) {
                        Text("Download PDF")
                    }
                }

                is PdfUiState.Loading -> {
                    CircularProgressIndicator()
                }

                is PdfUiState.Success -> {
                    val pdfData = (uiState as PdfUiState.Success).pdfData
                    val pdfState = rememberVerticalPdfReaderState(
                        resource = ResourceType.Base64(Base64.encode(pdfData, 0)),
                        isZoomEnable = true,
                    )

                    VerticalPDFReader(
                        state = pdfState,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.White),
                    )
                }

                is PdfUiState.Error -> {
                    val errorMessage = (uiState as PdfUiState.Error).exceptionMessage
                    if (errorMessage.isNotEmpty()) {
                        Text(text = errorMessage, color = Color.Red)
                    }
                }

                else -> Unit
            }
        }
    }
}
