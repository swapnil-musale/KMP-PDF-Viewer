import SwiftUI
import MultiPlatformLibrary

@main
struct iOSApp: App {
    init() {
        KoinHelperKt.doInitKoin()
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
