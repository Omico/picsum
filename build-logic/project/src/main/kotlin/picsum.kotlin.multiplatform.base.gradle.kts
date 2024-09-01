import me.omico.gradle.project.PROJECT_JAVA_VERSION
import me.omico.gradle.project.createSourcePackageDirectories
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    kotlin("multiplatform")
}

kotlin {
    jvmToolchain(PROJECT_JAVA_VERSION)

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        allWarningsAsErrors = true
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
