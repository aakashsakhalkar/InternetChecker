📡 InternetChecker
A lightweight Android utility library to check internet connectivity, type of connection, and whether the device is using Wi-Fi or mobile data.

🚀 Features
Detects if the device is connected to the internet

Identifies connection type: Wi-Fi or Mobile Data

Checks if the connection is validated

Simple static methods, no setup required

🔧 Installation
Step 1: Add JitPack to your repositories
Groovy (settings.gradle):

dependencyResolutionManagement {
 repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
 repositories {
  mavenCentral()
  maven { url 'https://jitpack.io' }
 }
}

Kotlin DSL (settings.gradle.kts):

dependencyResolutionManagement {
 repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
 repositories {
  mavenCentral()
  maven { url = uri("https://jitpack.io") }
 }
}

Step 2: Add the dependency
Replace Tag with the latest release tag, for example: v1.0.1.

Groovy (app/build.gradle):

dependencies {
 implementation 'com.github.aakashsakhalkar:InternetChecker:Tag'
}

Kotlin DSL (build.gradle.kts):

dependencies {
 implementation("com.github.aakashsakhalkar:InternetChecker:Tag")
}

Maven:

<dependency>  <groupId>com.github.aakashsakhalkar</groupId>  <artifactId>InternetChecker</artifactId>  <version>Tag</version> </dependency>
🧩 Usage
Import the class:

import com.aakash.netstatus.NetStatus;

Example usage:

if (NetStatus.isConnectedToInternet(context)) {
 String type = NetStatus.getConnectionType(context);
 Log.d("Network", "Connected via " + type);
} else {
 Log.d("Network", "No internet connection");
}

📘 API Reference
Method	Description
isConnectedToInternet(ctx)	Returns true if device has validated internet access
hasWiFi(ctx)	Returns true if device is currently using Wi-Fi
hasMobileData(ctx)	Returns true if device is using mobile/cellular data
getConnectionType(ctx)	Returns "WIFI", "MOBILE", or "NONE"

All methods are static and can be used directly without initialization.

🛠 Requirements
Minimum SDK: 21 (Android 5.0 Lollipop)

No additional dependencies

🧾 License
MIT License
