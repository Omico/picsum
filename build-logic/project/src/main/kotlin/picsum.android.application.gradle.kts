import me.omico.consensus.root.consensusRootProjectConfiguration
import me.omico.gradle.project.PROJECT_JAVA_VERSION
import me.omico.gradle.project.configureAndroidSigningConfigForRelease

plugins {
    id("com.android.application")
    id("picsum.android.base")
    id("picsum.kotlin.android.base")
}

configureAndroidSigningConfigForRelease()

android {
    defaultConfig {
        versionCode = consensusRootProjectConfiguration.versionCode
        versionName = consensusRootProjectConfiguration.versionName
    }
    buildFeatures {
        buildConfig = true
    }
    kotlinOptions {
        jvmTarget = PROJECT_JAVA_VERSION.toString()
    }
    buildTypes {
        all {
            @Suppress("UnstableApiUsage")
            vcsInfo.include = false
        }
    }
}
