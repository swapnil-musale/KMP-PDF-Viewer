# PDF Viewer
The PDF Viewer is simple app which demonstrates how we can display PDF in android and iOS platform in **Kotlin Multiplatform** project.

| Platforms | ![](https://img.shields.io/badge/Android-black.svg?style=for-the-badge&logo=android) ![](https://img.shields.io/badge/iOS-black.svg?style=for-the-badge&logo=apple)  |
|-----------|---|

### Demo

<table style="width:100">
  <tr>
    <th>Android</th> 
  </tr>
  <tr>
    <td><video src = "https://github.com/swapnil-musale/KMP-PDF-Viewer/assets/15209914/fd4f17e3-0500-4502-b22b-40d0c5ce5f84" width=250/></td>
  </tr>
</table>

### iOS App

<table style="width:100">
  <tr>
    <th>iOS</th> 
  </tr>
  <tr>
    <td><video src = "https://github.com/swapnil-musale/KMP-PDF-Viewer/assets/15209914/90b19f45-f88b-493b-89da-9ec2bce73bc9" width=250/></td>
  </tr>
</table>


## Built with

- [Kotlin](kotlinlang.org) : Multiplatform Programming language
- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html) : To host the common bussiness logic of Android and iOS app.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) : Android App UI built using Jetpack Compose.
- [Swift UI](https://developer.apple.com/xcode/swiftui/) : iOS App UI built using Swift UI.
- [Moko MVVM](https://github.com/icerockdev/moko-mvvm) : Share ViewModel with android and iOS app.
- [DI](https://insert-koin.io/) : Koin used for Dependency Injection.
- [Networking](https://ktor.io/) : Ktor used for network calls.

## Project structure

This Kotlin Multiplatform project includes three modules:

### shared
This is a Kotlin module that contains the common logic for both Android and iOS applications, the code you share between platforms.
This shared module contains ViewModel, Network related common code.

### androidApp
This androidApp module is used to write android UI in Jetpack Compose and other platofrm specific code.

### iosApp
This iosApp module is used to write ios app UI in Swift UI and other platform specific code.

## How to run the app
This project build upon **Android Studio** Hedgehog | 2023.1.1 and **XCode** | 15.0.1.

## License
 ```
 Copyright 2023 Swapnil Musale

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   ```
