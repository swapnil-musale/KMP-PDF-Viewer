package com.devx.pdf_viewer_kmp.android

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devx.pdf_viewer_kmp.PdfViewModel
import com.rizzi.bouquet.ResourceType
import com.rizzi.bouquet.VerticalPDFReader
import com.rizzi.bouquet.rememberVerticalPdfReaderState
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
@Composable
fun App() {
    MyApplicationTheme {
        val pdfViewModel: PdfViewModel = viewModel()
        val pdfData by pdfViewModel.pdfData.collectAsState()

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Button(onClick = {
                pdfViewModel.downloadPDF()
            }) {
                Text("Download PDF")
            }

            AnimatedVisibility(visible = pdfData != null) {
                val pdfState = rememberVerticalPdfReaderState(
                    resource = ResourceType.Base64(Base64.encode(pdfData!!, 0)),
                    isZoomEnable = true,
                )

                VerticalPDFReader(
                    state = pdfState,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White),
                )
            }
        }
    }
}
