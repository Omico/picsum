import me.omico.gradle.project.PROJECT_JAVA_VERSION
import me.omico.gradle.project.createSourcePackageDirectories
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("picsum.android.base")
}

kotlin {
    jvmToolchain(PROJECT_JAVA_VERSION)

    androidTarget()

    jvm("desktop")

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
