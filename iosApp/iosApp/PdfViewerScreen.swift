
import SwiftUI
import PDFKit

struct PDFViewer: UIViewRepresentable {
    let data: Data
    
    func makeUIView(context: Context) -> PDFView {
        // Create a PDFView and set its properties
        let pdfView = PDFView()
        pdfView.autoScales = true
        return pdfView
    }
    
    func updateUIView(_ uiView: PDFView, context: Context) {
        if let document = PDFDocument(data: data) {
            uiView.document = document
        }
    }
}

