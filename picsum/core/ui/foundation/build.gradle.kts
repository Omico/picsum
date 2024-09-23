plugins {
    id("picsum.compose.multiplatform.library")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":picsum-androidx-paging-compose"))
            }
            dependencies {
                api(project(":picsum-androidx-paging-compose"))
                implementation(project(":picsum-core-foundation"))
            }
            dependencies {
                api(androidx.lifecycle.viewmodel)
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
