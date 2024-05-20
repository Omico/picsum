plugins {
    id("picsum.kotlin.multiplatform.library")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":picsum-core-api"))
            }
        }
    }
}
