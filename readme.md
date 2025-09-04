# Poketest Project

This project is an Android application built with **Kotlin** and **Jetpack Compose** for demonstration purposes in an interview setting. It uses the [PokéAPI](https://pokeapi.co/) to display Pokémon data.

Perfeito, Igor 👍 Vou adicionar essa seção no **README** para orientar o candidato. Ela vai deixar claro que ele não precisa programar nada, apenas entender o projeto, executar, e estar preparado para discutir pontos fortes, melhorias e possíveis problemas. Também vou incluir a instrução de contato em caso de falhas.

Aqui está a versão atualizada do trecho a ser inserido no final do README:

---

Beleza 👍 Entendi. Vou ajustar a seção para deixar claro que o candidato pode fazer pequenas alterações para conseguir rodar o projeto, mas se mesmo assim não conseguir, deve entrar em contato com a organização da entrevista.

Aqui está a versão revisada:

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
