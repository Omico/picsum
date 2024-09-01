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
                api(compose.material3)
                api(coil.compose)
            }
            dependencies {
                implementation(coil.network.ktor)
            }
        }

        desktopMain {
            dependencies {
                api(compose.preview)
            }
        }
    }
}

android {
    buildFeatures {
        buildConfig = true
    }
}
