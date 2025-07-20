plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    namespace = "com.aakash.netstatus"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

dependencies {
    implementation("androidx.annotation:annotation:1.7.1")
}

afterEvaluate {
    extensions.configure<PublishingExtension>("publishing") {
        publications {
            create<MavenPublication>("release") {
                groupId = "com.github.aakashsakhalkar"
                artifactId = "NetStatus"
                version = "1.0.1"

                // This is the fix that avoids "component not found"
                components["release"]?.let { from(it) }
            }
        }
    }
}
//git tag -d v1.0.1
//git push origin :refs/tags/v1.0.1
//git tag v1.0.1
//git push origin v1.0.1
