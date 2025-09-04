# Poketest Project

This project is an Android application built with **Kotlin** and **Jetpack Compose** for demonstration purposes in an interview setting. It uses the [PokéAPI](https://pokeapi.co/) to display Pokémon data.
---

## 📑 Candidate Instructions

This project is provided **as-is** for interview purposes.
To successfully complete this stage, the candidate must:

1. **Run the project** in Android Studio, following the steps described above.
2. **Understand the project** at a high level in order to give an **overview** if asked during the interview.
3. Be ready to **point out possible improvements** and **identify potential issues** in the code, architecture, or design.

### ⚠️ Important Notes

* You **do not need to implement or code anything new**.
* Your goal is to be familiar enough with the application to discuss it.
* If you encounter difficulties running the project, feel free to make adjustments necessary to get it working. If you are still unable to run it, please **contact the interview organizers via email** (details provided in the interview invitation).

---


### ⚠️ Important Notes

* You **do not need to implement or code anything new**.
* Your goal is to be familiar enough with the application to discuss it.
* If you face any technical difficulties running the project, please **contact the interview organizer via email** (details provided in the interview invitation).


---

## 📋 Requirements

- Android Studio (latest stable version recommended)  
- JDK 17+  
- Gradle (wrapper already included)  
- Internet connection (for fetching data from the API)

---

## 🚀 How to Run

1. **Clone the project**  
   ```bash
   git clone <repository_url>
   cd poketest
   ```

2. **Open in Android Studio**  
   - Open `poketest` as the root project.  
   - Let Gradle sync automatically (the wrapper `gradlew` is included).  

3. **Set up `local.properties`**  
   Ensure your `local.properties` file contains the path to the Android SDK:  
   ```properties
   sdk.dir=/path/to/Android/Sdk
   ```

4. **Build & Run**  
   - Choose a device/emulator with **API level 26+**.  
   - Run the app (click ▶ in Android Studio).  

---
## 🛠️ Tech Stack

- **Kotlin**  
- **Jetpack Compose**  
- **Coroutines & Flow**  
- **Retrofit + OkHttp** (API calls)  
- **Coil** (image loading)  
- **MVVM architecture**  

---

## 📂 Project Structure

- `app/` – Main Android module  
- `ui/` – Composables and screens  
- `data/` – API models and repository  
- `viewmodel/` – State management with ViewModel  
