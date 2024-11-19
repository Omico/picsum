import me.omico.consensus.root.consensusRootProjectConfiguration
import me.omico.gradle.project.PROJECT_JAVA_VERSION
import me.omico.gradle.project.configureAndroidSigningConfigForRelease

plugins {
    id("me.omico.kami.kotlin.android")
    id("me.omico.kami.android.application")
    id("picsum.android.base")
}

kotlin {
    jvmToolchain(PROJECT_JAVA_VERSION)
}

configureAndroidSigningConfigForRelease()

android {
    defaultConfig {
        versionCode = consensusRootProjectConfiguration.versionCode
        versionName = consensusRootProjectConfiguration.versionName
    }
//    kotlinOptions {
//        jvmTarget = PROJECT_JAVA_VERSION.toString()
//    }
}
