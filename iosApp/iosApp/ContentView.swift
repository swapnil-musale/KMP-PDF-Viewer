import SwiftUI
import PDFKit
import shared
import mokoMvvmFlowSwiftUI
import MultiPlatformLibrary

struct ContentView: View {

    @ObservedObject var viewModel = KoinHelper().getPdfViewModel()
    
    @State var uiState: PdfUiState = PdfUiStateUninitialized()
    
	var body: some View {
        let appUiState = viewModel.uiState
        VStack{
            switch(uiState){
            case is PdfUiStateUninitialized:
                Button("Download PDF") {
                    viewModel.downloadPDF()
                }
            case is PdfUiStateLoading:
                LoadingView()
            case let successState as PdfUiStateSuccess:
                let pdfData: String = (successState as PdfUiStateSuccess).encodedBase64Data
                if let data = Data(base64Encoded: pdfData) {
                    PDFViewer(data: data).edgesIgnoringSafeArea(.all)
                }
            case is PdfUiStateError:
                ErrorView()
            default:
                ErrorView()
            }
        }.onAppear {
            appUiState.subscribe { state in
                self.uiState = state!
            }
        }
	}
}

struct preparePdfView: View {
    let pdfData = Data(base64Encoded: "")
    var body: some View {
        Text("Display PDF")
//        let pdfView = PDFView()
//        var doc = PdfDocument(pdfData);
//        pdfView.document = doc
    }
}

struct LoadingView: View {
    var body: some View {
        ProgressView()
            .padding()
    }
}

struct RenderPdfView: View {
    var body: some View {
        Text("Show Data")
    }
}

struct ErrorView: View {
    var body: some View {
        Text("An error occurred. Please try again.")
            .foregroundColor(.red)
            .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
