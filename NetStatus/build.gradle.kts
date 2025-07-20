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
    implementation(libs.annotation.jvm)
}

// ✅ MOVE publishing.publications block into afterEvaluate
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "com.github.aakashsakhalkar"
                artifactId = "NetStatus"
                version = "1.0.0"
                from(components["release"])
            }
        }
        repositories {
            maven {
                name = "GithubPackages"
                url = uri("https://maven.pkg.github.com/aakashsakhalkar/NetStatus")
                credentials {
                    username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                    password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
                }
            }
        }
    }
}
