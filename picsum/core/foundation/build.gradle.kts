plugins {
    id("picsum.kotlin.multiplatform.library")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(kotlinx.coroutines.core)
                api(okio)
            }
        }
    }
}
