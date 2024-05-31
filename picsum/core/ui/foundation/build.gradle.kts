plugins {
    id("picsum.compose.multiplatform.library")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":picsum-core-foundation"))
            }
            dependencies {
                api(androidx.compose.foundation)
                api(androidx.compose.material3)
                api(coil.compose)
            }
            dependencies {
                implementation(coil.network.ktor)
            }
        }

        jvmMain {
            dependencies {
                api(androidx.compose.ui.tooling.preview)
            }
        }
    }
}

android {
    buildFeatures {
        buildConfig = true
    }
}
