plugins {
    id("picsum.compose.multiplatform.library")
    id("picsum.hilt")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":picsum-core-ui"))
                implementation(project(":picsum-core-data"))
            }
        }
    }
}
