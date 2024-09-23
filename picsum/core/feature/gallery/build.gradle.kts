plugins {
    id("picsum.compose.multiplatform.library")
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
