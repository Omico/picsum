plugins {
    id("me.omico.kami.kotlin.multiplatform")
    id("me.omico.kami.compose")
    id("picsum.android.base")
}

kami {
    kotlin {
        jvmToolchain(21)
        jvmTarget(11)
        compilerPlugins {
            serialization()
        }
        multiplatform {
            // android() is only available in the build logic for basic configuration.
            // androidApplication(), androidLibrary() and androidDynamicFeature()
            // are available in the both build logic and project module, but can only apply one of them.
            androidLibrary()
            jvm()
        }
    }
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                kamiDependencies {
                    implementation(compose.material3.adaptive)
                }
            }
            dependencies {
                kamiDependencies {
                    implementation(kotlinx.serialization.json)
                }
            }
        }
    }
}

afterEvaluate {
    logger.lifecycle("The current Compose Multiplatform version which is used by Kami is ${kami.compose.version}.")
}
