plugins {
    id("picsum.kotlin.multiplatform.library.hilt")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":picsum-core-api"))
                implementation(project(":picsum-core-data-database"))
                implementation(project(":picsum-core-data-model"))
                implementation(project(":picsum-core-foundation"))
            }
            dependencies {
                implementation(androidx.paging.common)
            }
        }
    }
}
