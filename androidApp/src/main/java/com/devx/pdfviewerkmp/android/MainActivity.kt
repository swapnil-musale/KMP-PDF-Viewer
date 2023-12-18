package com.devx.pdfviewerkmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.devx.pdfviewerkmp.android.theme.AppTheme
import com.devx.pdfviewerkmp.android.ui.PdfViewerScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PdfViewerScreen()
        }
    }
}

@Preview
@Composable
private fun PdfViewerScreenPreview() {
    AppTheme {
        PdfViewerScreen()
    }
}
