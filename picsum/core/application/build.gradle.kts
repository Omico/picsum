import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("picsum.compose.multiplatform.library")
    id("picsum.hilt")
}

kotlin {
    targets.withType<KotlinNativeTarget>()
        .matching { it.konanTarget.family.isAppleFamily }
        .configureEach {
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
