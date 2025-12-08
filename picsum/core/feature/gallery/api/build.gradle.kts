plugins {
    id("picsum.compose.multiplatform.library")
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":picsum-core-ui"))
            }
        }
    }
}
