plugins {
    id("picsum.kotlin.multiplatform.library")
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
