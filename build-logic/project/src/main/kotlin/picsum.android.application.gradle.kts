import me.omico.gradle.project.configureCommonAndroidCompose
import me.omico.gradm.Versions

plugins {
    kotlin("android")
    id("com.android.application")
    id("picsum.android.base")
}

configureCommonAndroidCompose(
    jetpackComposeCompilerVersion = Versions.androidx.compose.compiler,
)

android {
    defaultConfig {
        versionCode = 1
        versionName = version.toString()
    }
    buildFeatures {
        buildConfig = true
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}
