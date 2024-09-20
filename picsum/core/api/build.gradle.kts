plugins {
    id("picsum.kotlin.multiplatform.library.hilt")
}

kami {
    kotlin {
        compilerPlugins {
            serialization()
        }
    }
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":picsum-core-foundation"))
            }
            dependencies {
                implementation(ktor.client.content.negotiation)
                implementation(ktor.serialization.kotlinx.json)
                kamiDependencies {
                    implementation(kotlinx.serialization.json)
                }
            }
        }

        commonJvmMain {
            dependencies {
                implementation(ktor.client.okhttp)
            }
        }

        appleMain {
            dependencies {
                implementation(ktor.client.darwin)
            }
        }
    }
}
