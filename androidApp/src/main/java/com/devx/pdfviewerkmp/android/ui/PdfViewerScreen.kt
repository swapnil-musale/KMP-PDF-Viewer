package com.devx.pdfviewerkmp.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devx.pdfviewerkmp.PdfUiState
import com.devx.pdfviewerkmp.PdfViewModel
import com.devx.pdfviewerkmp.android.theme.AppTheme
import com.rizzi.bouquet.ResourceType
import com.rizzi.bouquet.VerticalPDFReader
import com.rizzi.bouquet.rememberVerticalPdfReaderState
import io.ktor.util.encodeBase64
import org.koin.androidx.compose.getViewModel
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
@Composable
fun PdfViewerScreen() {
    AppTheme {
        val pdfViewModel: PdfViewModel = getViewModel()
        val uiState by pdfViewModel.uiState.collectAsStateWithLifecycle()

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
                    val pdfData = (uiState as PdfUiState.Success).pdfData.encodeBase64()
                    val pdfState = rememberVerticalPdfReaderState(
                        resource = ResourceType.Base64(pdfData),
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
