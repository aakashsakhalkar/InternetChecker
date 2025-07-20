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
</details>

<details>
<summary><strong>Kotlin DSL (settings.gradle.kts)</strong></summary>

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

---

### Step 2: Add the dependency  
Replace `Tag` with the latest release tag (e.g., `v1.0.1`).

<details>
<summary><strong>Groovy (app/build.gradle)</strong></summary>

```groovy
dependencies {
     implementation 'com.github.aakashsakhalkar:InternetChecker:v1.0.1'
}
```
</details>

<details>
<summary><strong>Kotlin DSL (build.gradle.kts)</strong></summary>

```kotlin
dependencies {
   implementation 'com.github.aakashsakhalkar:InternetChecker:v1.0.1'
}
```
</details>

<details>
<summary><strong>Maven</strong></summary>

```xml
<dependency>
    <groupId>com.github.aakashsakhalkar</groupId>
    <artifactId>InternetChecker</artifactId>
    <version>Tag</version>
</dependency>
```
</details>

---

## 🧩 Usage

**Import the class:**

```java
import com.aakash.netstatus.NetStatus;
```

**Example:**

```java
if (NetStatus.isConnectedToInternet(context)) {
    String type = NetStatus.getConnectionType(context);
    Log.d("Network", "Connected via " + type);
} else {
    Log.d("Network", "No internet connection");
}
```

---

## 📘 API Reference

| Method                    | Description                                           |
|---------------------------|-------------------------------------------------------|
| `isConnectedToInternet(ctx)` | Returns true if device has validated internet access |
| `hasWiFi(ctx)`               | Returns true if device is currently using Wi-Fi     |
| `hasMobileData(ctx)`         | Returns true if device is using mobile data         |
| `getConnectionType(ctx)`     | Returns `"WIFI"`, `"MOBILE"`, or `"NONE"`           |

> All methods are static and can be used directly without initialization.

---

## 🛠 Requirements

- **Minimum SDK:** 21 (Android 5.0 Lollipop)  
- **No additional dependencies**

---

## 🧾 License

MIT License
