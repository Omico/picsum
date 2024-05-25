plugins {
    id("picsum.compose.multiplatform.library")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":picsum-core-ui-foundation"))
            }
        }
    }
}
