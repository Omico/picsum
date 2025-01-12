plugins {
    id("picsum.kotlin.multiplatform.library.hilt")
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":picsum-core-foundation"))
            }
            dependencies {
                implementation(kotlinx.serialization.json)
                implementation(ktor.client.content.negotiation)
                implementation(ktor.serialization.kotlinx.json)
            }
        }

        commonJvmMain {
            dependencies {
                implementation(ktor.client.okhttp)
            }
        }
    }
}
