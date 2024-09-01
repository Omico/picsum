import me.omico.gradle.project.PROJECT_JAVA_VERSION
import me.omico.gradle.project.createSourcePackageDirectories
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    id("com.android.library")
    id("picsum.android.base")
    id("picsum.kotlin.multiplatform.base")
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
            group("jvmCommon") {
                withAndroidTarget()
                withJvm()
            }
        }
    }

    sourceSets {
        all {
            languageSettings {
                enableLanguageFeature("ExpectActualClasses") // TODO KT-61573
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        createSourcePackageDirectories(project)
    }
}
