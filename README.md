# 📡 InternetChecker

A lightweight Android utility library to check internet connectivity, type of connection, and whether the device is using Wi-Fi or mobile data.

---

## 🚀 Features

- Detects if the device is connected to the internet
- Identifies connection type: Wi-Fi or Mobile Data
- Checks if the connection is validated
- Simple static methods, no setup required

---

## 🔧 Installation

### Step 1: Add JitPack to your repositories

<details>
<summary><strong>Groovy (settings.gradle)</strong></summary>

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```
</details> <details> <summary><strong>Kotlin DSL (settings.gradle.kts)</strong></summary>
```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```
</details>
