

# Android Testing
#### Jan 5th 2022
#### By **peteHack**


Open source shoppingList application demonstrating how to use different libraries to test android components in Jetpack. unit tests, integration tests, ui tests for:
- Testing Room
- Testing ViewModels
- Creating fake repository and Test doubles
- Testing Navigation with Mockito and Espresso
- Testing with dagger hilt & retrofit
- Testing APIs using mock web server
- Testing fragments with dagger hilt

## Prerequisite

minSdkVersion -> 21

Gradle build system

Head over to the Pixabay api and get your own API-KEY as well.


## TOC

- [Architecture](#architecture)
- [Libraries](#libraries)
- [Extras](#extras)
- [Contacts](#Contacts)

## Architecture

### Implemented using Clean Architecture
The application is built using MVVM architecture, the following diagram shows the structure of this project with 3 layers:

<br>
<p align="center">
  <img src="https://github.com/peter-wachira/TMDBClient/blob/master/diagram.png" width="750"/>
</p>
<br>

### Communication between layers

1. UI calls method from ViewModel.
2. ViewModel executes methods called from repository .
3. Repository returns data from a Data Source (Local or Remote).
4. Information flows back to the UI where UI observes LiveData Object to display the list of added shopping Items.


The App is not organized into multiple modules but follows the same principles of
MVVM architecture.

The presentation layer handles the UI work with the logic contained in the **ViewModel**.
The UI uses a **LiveData** object from the ViewModel and observes it using the **Observer Pattern**.
A ListAdapter handles the actual displaying of the shoppingItems. Data over the network is retrieved using
**retrofit** and **coroutines** to handle background work asynchronously. Additionally, note that
the ViewModel uses the **viewModelScope** to launch the coroutines while Fragments use the **viewLifeCycleOwner**
to observe data.
The data layer uses the recommended **Repository Pattern** to make the network calls and store the data using
**Room DB**.
 
## Libraries Used

This app will make use of the following libraries:

- [Jetpack](https://developer.android.com/jetpack)🚀

  Android Components Dependencies
  
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI data to survive configuration changes and is lifecycle-aware
  - [Data Binding](https://developer.android.com/topic/libraries/data-binding) - Declaratively bind observable data to UI elements
  - [Navigation](https://developer.android.com/guide/navigation/) - Handle everything needed for in-app navigation
  - [Room DB](https://developer.android.com/topic/libraries/architecture/room) - Fluent SQLite database access
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Notify views when underlying database changes
 
  Testing Dependencies
  
  - [Espresso](https://developer.android.com/training/testing/espresso) - Use Espresso to write concise, beautiful, and reliable Android UI tests.
  - [Mockito](https://github.com/mockito/mockito) - Mockito is a popular open source framework for mocking objects in software test.
  - [Robolectric]() - Robolectric is a framework that brings fast and reliable unit tests to Android. Tests run inside the JVM 
  - [Hamcrest](http://hamcrest.org/JavaHamcrest/) - A framework that assists writing software tests in the Java programming language. It supports creating customized assertion matchers
  - [Google Truth Library](https://github.com/google/truth) - Truth makes your test assertions and failure messages more readable.
  - [Junit](https://junit.org/junit4/) - JUnit is a unit testing framework for the Java programming language.
  - [MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver) - Testing API endpoints 
  - [Retrofit](https://square.github.io/retrofit/) - type safe http client with coroutines support
  - [Gson](https://github.com/google/gson) - A Java serialization/deserialization library to convert Java Objects into JSON and back
  - [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - A fast dependency injector for Android and Java.
  - [okhttp-logging-interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - logging HTTP request related data.
  - [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines
  - [Material Design](https://material.io/develop/android/docs/getting-started/) - build awesome beautiful UIs.🔥🔥
  - [Glide](https://github.com/bumptech/glide) - Hassle-free image loading
  - [Timber](https://github.com/JakeWharton/timber) - A logger with a small, extensible API which provides utility on top of Android's normal Log class.


## Extras

### Known Bugs

- The project is currently being maintained any. Contributions are most welcome if you would like to add more modules to the project, you can reach me through my [Contacts](#Contacts) below.
- Thanks for understanding.


#### CI-Pipeline

[Github Actions CI](https://github.com/features/actions/) is used for Continuous Integration every time an update is made
to the repo. The configuration is in the .develop.yml .master.yml .branch.yml*** files

#### Code Analysis and test coverage

This code uses [Codacy](https://www.codacy.com/) for analysing the quality of the code, which is
always going to be > B :)

```
  MIT License
  
  Copyright (c) 2019 PeteHack
  
  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:
  
  The above copyright notice and this permission notice shall be included in all
  copies or substantial portions of the Software.
  
  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
  SOFTWARE.

```


## Contacts

```bash

You can reach me via my personal email pwachira900@gmail.com or my website for contibutions or reuse


