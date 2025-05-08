plugins {
    id("picsum.compose.multiplatform.library")
    id("picsum.hilt")
}

kotlin {
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
