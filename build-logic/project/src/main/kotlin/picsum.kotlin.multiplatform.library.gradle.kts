import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    id("com.android.library")
    id("picsum.android.base")
    id("picsum.kotlin.multiplatform.base")
    id("me.omico.dehell")
}

kotlin {
    androidTarget()

    jvm("desktop")

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    applyDefaultHierarchyTemplate {
        common {
            group("commonJvm") {
                withAndroidTarget()
                withJvm()
            }
        }
    }
}

dehell {
    variant = "release"
}
