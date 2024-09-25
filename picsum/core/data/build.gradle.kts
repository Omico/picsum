plugins {
    id("picsum.kotlin.multiplatform.library")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":picsum-core-data-model"))
                api(project(":picsum-core-data-repository"))
            }
            dependencies {
                implementation(project(":picsum-core-data-database"))
            }
        }
    }
}
