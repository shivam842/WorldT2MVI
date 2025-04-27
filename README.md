# World T2

**Description**  
WorldT2 is an Android application where users can simulate a cricket match between two teams. The app utilizes the MVI (Model-View-Intent) architecture to maintain a clean and scalable design. The main goal of the app is to simulate and visualize the gameplay of cricket matches with real-time updates and interactions.

**🏏 Features**  
- **Cricket Match Simulation**: Simulate and manage a live cricket match between two teams.
- **Teams**: Define teams and their roles.
- **Live Score Updates**: Track the live score, wickets, and other game metrics.
- **MVI Architecture**: Structured using the MVI design pattern to separate concerns.
- **Interactive UI**: Easy-to-use interface to interact with the match and simulate gameplay.
- **Real-time Match Status**: Get real-time updates for match events like wickets, runs, and more.

**🛠️ Technologies Used**  
- **Android**: Kotlin-based Android app.
- **MVI Architecture**: Model-View-Intent architecture for managing the app’s UI and data flow.
- **ViewModel**: To manage UI-related data in a lifecycle-conscious way.
- **LiveData**: For observing changes to the data and updating the UI in real-time.
- **Kotlin Coroutines**: For managing asynchronous tasks like network requests or background processing.

**🏗️ Folder Structure**  
```
WorldT2MVI/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/mcoder/worldt2mvi/
│   │   │   │   ├── ui/
│   │   │   │   │   ├── components/          # Reusable UI components
│   │   │   │   │   ├── screens/             # Feature screens with MVI implementation
│   │   │   │   │   └── viewmodel/           # ViewModel classes managing UI state
│   │   │   │   ├── data/
│   │   │   │   │   ├── model/                # Data models and entities
│   │   │   │   │   ├── repository/           # Data sources abstraction
│   │   │   │   │   └── remote/               # API clients and network logic
│   │   │   │   ├── domain/
│   │   │   │   │   ├── usecases/             # Business logic encapsulation
│   │   │   │   │   └── mvi/                  # MVI intents, states, and reducers
│   │   │   ├── res/                          # Resources: layouts, strings, themes, images
│   │   │   ├── AndroidManifest.xml          # App manifest file
│   │   ├── build.gradle                     # Module-level Gradle configuration
│   ├── build.gradle                         # Project-level Gradle configuration
├── build/                                  # Build outputs
├── gradle/                                 # Gradle wrapper files
├── .gitignore                             # Specifies intentionally untracked files
├── README.md                              # This file
└── settings.gradle                        # Gradle settings file
```

**🚀 Getting Started**  

**Prerequisites**  
- Android Studio installed on your machine.
- Basic knowledge of Kotlin and Android development.
- Gradle for managing dependencies.

**Installation**  
1. Clone the repository:
   ```bash
   git clone https://github.com/shivam842/WorldT2MVI.git
   ```

2. Open the project in Android Studio.

3. Sync the project with Gradle files.

4. Build and run the app on an emulator or physical device.

**📄 License**  
This project is licensed under the MIT License - see the LICENSE file for details.

**🤝 Contributing**  
1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature-name
   ```

3. Make your changes and commit:
   ```bash
   git commit -am 'Add new feature'
   ```

4. Push to your branch:
   ```bash
   git push origin feature-name
   ```

5. Create a pull request.

**📬 Contact**  
Email: shivampawar842@gmail.com
