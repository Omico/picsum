import me.omico.consensus.root.consensusRootProjectConfiguration
import me.omico.gradle.project.PROJECT_JAVA_VERSION
import me.omico.gradle.project.configureAndroidSigningConfigForRelease

plugins {
    id("me.omico.kami.android.application")
    id("picsum.android.base")
    id("picsum.kotlin.android.base")
    id("picsum.dehell")
}

configureAndroidSigningConfigForRelease()

android {
    defaultConfig {
        versionCode = consensusRootProjectConfiguration.versionCode
        versionName = consensusRootProjectConfiguration.versionName
    }
}

kami {
    android {
        application {
            coreLibraryDesugaring("com.android.tools:desugar_jdk_libs_nio:2.1.2")
        }
    }
    kotlin {
        jvmToolchain(PROJECT_JAVA_VERSION)
    }
}

dehell {
    variant = "release"
}
