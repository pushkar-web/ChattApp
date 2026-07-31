# 💬 ChattApp

<div align="center">

# 🚀 ChattApp

### Modern Android Chat Application built with Kotlin & Jetpack Compose

A feature-rich Android messaging application that provides a modern chat experience using **Jetpack Compose**, **Firebase Authentication**, **Cloud Firestore**, and **Material 3**. The application offers secure authentication, intuitive navigation, profile management, and a clean user interface following modern Android development practices.

![Android](https://img.shields.io/badge/Android-34-3DDC84?style=for-the-badge\&logo=android)
![Kotlin](https://img.shields.io/badge/Kotlin-100%7CJetpack%20Compose-7F52FF?style=for-the-badge\&logo=kotlin)
![Firebase](https://img.shields.io/badge/Firebase-Authentication-FFCA28?style=for-the-badge\&logo=firebase)
![Firestore](https://img.shields.io/badge/Cloud-Firestore-FFCA28?style=for-the-badge\&logo=firebase)
![Material3](https://img.shields.io/badge/Material-3-2196F3?style=for-the-badge)

</div>

---

# 📖 Overview

ChattApp is a modern Android messaging application developed using **Kotlin** and **Jetpack Compose**. The application focuses on providing a smooth, responsive, and user-friendly chatting experience while following the latest Android development architecture.

The application integrates Firebase services for authentication and cloud data management while utilizing Jetpack Compose to deliver a clean and reactive user interface. With multiple authentication methods and modular navigation, ChattApp serves as a strong foundation for scalable real-time messaging applications.

---

# ✨ Features

* 💬 Modern Chat Interface
* 🔐 Firebase Authentication
* 🔑 Google Sign-In
* 📱 Phone Number Authentication
* 👤 User Profile Management
* 🏠 Home Dashboard
* 📂 Bottom Navigation
* ☁️ Cloud Firestore Integration
* 💾 Local Data Persistence using DataStore
* 🎨 Material 3 UI
* 🎬 Lottie Animations
* 🧭 Navigation Component
* ⚡ Reactive Jetpack Compose UI
* 🤖 Google Generative AI Dependency Integration
* 📱 Android 7.0+ Support (API 24)

---

# 🛠 Tech Stack

| Category       | Technology               |
| -------------- | ------------------------ |
| Language       | Kotlin                   |
| UI Framework   | Jetpack Compose          |
| Architecture   | Android Jetpack          |
| Navigation     | Navigation Compose       |
| Authentication | Firebase Authentication  |
| Database       | Cloud Firestore          |
| Local Storage  | Android DataStore        |
| AI Integration | Google Generative AI SDK |
| Design System  | Material 3               |
| Animations     | Lottie                   |
| IDE            | Android Studio           |

---

# 📂 Project Structure

```text
ChattApp/
│
├── app/
│   ├── data/
│   │   ├── Chat.kt
│   │   ├── Person.kt
│   │   └── AllChats.kt
│   │
│   ├── navigation/
│   │   ├── Navcontroller.kt
│   │   ├── Screens.kt
│   │   └── SplashScreen.kt
│   │
│   ├── screens/
│   │   ├── HomeScreen.kt
│   │   ├── ChatScreen.kt
│   │   ├── ProfileScreen.kt
│   │   ├── StartScreen.kt
│   │   └── IconComponent.kt
│   │
│   ├── signin/
│   │   ├── GoogleAuthClient.kt
│   │   ├── PhoneSignIn.kt
│   │   ├── SignInViewModel.kt
│   │   ├── datastore/
│   │   └── firestore/
│   │
│   ├── bottombar/
│   ├── ui/
│   └── MainActivity.kt
│
└── README.md
```

---

# 🚀 Getting Started

## Clone Repository

```bash
git clone https://github.com/pushkar-web/ChattApp.git
```

Move into the project directory.

```bash
cd ChattApp
```

Open the project in **Android Studio**.

Sync the Gradle dependencies.

Run the application on an emulator or Android device.

---

# ⚙ Requirements

* Android Studio Hedgehog or newer
* JDK 17
* Android SDK 34
* Kotlin
* Firebase Project
* Google Services Configuration (`google-services.json`)

---

# 🔥 Firebase Configuration

Before running the application:

1. Create a Firebase project.
2. Enable **Authentication**.
3. Enable:

   * Google Sign-In
   * Phone Authentication
4. Create a Cloud Firestore database.
5. Download the `google-services.json` file.
6. Place it inside:

```text
app/google-services.json
```

---

# 📱 Application Flow

```text
Splash Screen
      │
      ▼
Authentication
      │
      ├──────────────┐
      ▼              ▼
Google Login   Phone Login
      │
      ▼
Home Screen
      │
      ├──────────────┐
      ▼              ▼
Chats          Profile
      │
      ▼
Conversation
```

---

# 🧩 Core Modules

## Authentication

Supports secure user authentication through:

* Google Sign-In
* Phone Number Authentication

---

## Home Screen

Displays the primary application interface with navigation to different sections of the application.

---

## Chat Module

Provides a modern messaging interface built using Jetpack Compose.

---

## Profile

Allows users to view and manage their profile information.

---

## Firestore Layer

Responsible for cloud-based user information storage and synchronization.

---

## DataStore

Stores lightweight user preferences locally for improved user experience.

---

# 🎨 UI Highlights

* Material 3 Components
* Modern Compose UI
* Responsive Layout
* Smooth Navigation
* Lottie Splash Animations
* Bottom Navigation Bar

---

# 📦 Major Libraries

* Jetpack Compose
* Material 3
* Firebase Authentication
* Firebase Firestore
* Google Sign-In
* Android DataStore
* Navigation Compose
* Google Generative AI SDK
* Lottie Compose

---

# 🔒 Security

The application follows secure Android development practices including:

* Firebase Authentication
* Secure Google Sign-In
* Phone OTP Verification
* Cloud-based user management
* Local preference isolation

---

# 🚀 Future Enhancements

* Real-time messaging
* Push notifications
* Image sharing
* Voice messages
* Video calling
* Group chats
* Read receipts
* Online presence
* End-to-end encryption
* AI-powered smart replies
* Media uploads
* Message search

---

# 🤝 Contributing

Contributions are welcome.

1. Fork the repository.
2. Create a new feature branch.

```bash
git checkout -b feature-name
```

3. Commit your changes.

```bash
git commit -m "Add new feature"
```

4. Push your branch.

```bash
git push origin feature-name
```

5. Open a Pull Request.

---

# 📄 License

This project is licensed under the **MIT License**.

---

# 👨‍💻 Author

**Pushkar Singh**

GitHub: https://github.com/pushkar-web

---

<div align="center">

### ⭐ If you found this project useful, please consider giving it a star!

Built with ❤️ using **Kotlin**, **Jetpack Compose**, and **Firebase**.

</div>
