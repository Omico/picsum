import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("picsum.compose.multiplatform.library")
}

kotlin {
    targets.withType<KotlinNativeTarget>().configureEach {
        if (name.startsWith("ios").not()) return@configureEach
        binaries {
            framework {
                baseName = "PicsumKt"
                isStatic = true
                binaryOption("bundleId", "me.omico.picsum.kmp")
            }
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                api(project(":picsum-core-data"))
                api(project(":picsum-core-ui"))
            }
            dependencies {
                api(project(":picsum-core-feature-gallery"))
            }
        }
    }
}
