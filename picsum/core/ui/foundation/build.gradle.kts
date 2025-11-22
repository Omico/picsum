plugins {
    id("picsum.compose.multiplatform.library")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":picsum-androidx-paging-compose"))
                implementation(project(":picsum-core-foundation"))
            }
            dependencies {
                api(androidx.lifecycle.viewmodel)
                api(androidx.lifecycle.viewmodel.navigation3)
                api(androidx.navigation3.runtime)
                api(androidx.navigation3.ui)
                api(coil.compose)
                api(compose.material3)
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
