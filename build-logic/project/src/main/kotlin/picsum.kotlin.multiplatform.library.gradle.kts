import me.omico.gradle.project.PROJECT_JAVA_VERSION
import me.omico.gradle.project.createSourcePackageDirectories
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("picsum.android.base")
}

kotlin {
    jvmToolchain(PROJECT_JAVA_VERSION)

    androidTarget()

    jvm("desktop")

    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        podfile = rootProject.file("picsum/ios/Podfile")
        summary = "Picsum Kotlin Multiplatform Library"
        homepage = "https://github.com/Omico/picsum"
        ios.deploymentTarget = "15"
    }

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        allWarningsAsErrors = true
    }

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    applyDefaultHierarchyTemplate {
        common {
            group("jvm") {
                withAndroidTarget()
                withJvm()
            }
        }
    }

    sourceSets {
        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        createSourcePackageDirectories(project)
    }
}
