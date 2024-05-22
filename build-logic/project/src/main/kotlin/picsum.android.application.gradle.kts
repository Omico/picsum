import me.omico.gradle.project.PROJECT_JAVA_VERSION
import me.omico.gradle.project.configureCommonAndroidCompose

plugins {
    kotlin("android")
    kotlin("plugin.compose")
    id("com.android.application")
    id("picsum.android.base")
}

configureCommonAndroidCompose()

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
