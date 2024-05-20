plugins {
    id("picsum.kotlin.multiplatform.library")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":picsum-core-data-database"))
                api(project(":picsum-core-data-model"))
                api(project(":picsum-core-data-repository"))
            }
        }
    }
}
