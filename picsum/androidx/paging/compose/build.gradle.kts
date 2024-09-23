plugins {
    id("picsum.compose.multiplatform.library")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(androidx.paging.common)
            }
            dependencies {
                implementation(compose.foundation)
            }
        }
    }
}
