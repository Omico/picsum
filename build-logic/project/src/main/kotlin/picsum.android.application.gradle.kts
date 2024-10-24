import me.omico.gradle.project.PROJECT_JAVA_VERSION
import me.omico.gradle.project.configureAndroidSigningConfigForRelease

plugins {
    kotlin("android")
    id("com.android.application")
    id("picsum.android.base")
    id("picsum.compose")
}

configureAndroidSigningConfigForRelease()

android {
    defaultConfig {
        versionCode = 1
        versionName = version.toString()
    }
    buildFeatures {
        buildConfig = true
    }
    kotlinOptions {
        jvmTarget = PROJECT_JAVA_VERSION.toString()
    }
}
