import me.omico.gradle.project.PROJECT_JAVA_VERSION
import me.omico.gradle.project.createDefaultSourcePackageDirectories
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    kotlin("multiplatform")
    id("picsum.spotless-kotlin")
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

        if (!path.startsWith(":picsum-androidx-")) {
            createDefaultSourcePackageDirectories(project)
        }
    }
}
