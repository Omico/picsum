plugins {
    id("me.omico.kami.kotlin.multiplatform")
    id("me.omico.kami.compose")
    id("picsum.android.base")
}

kami {
    compose {
        restrictVersion()
    }
    kotlin {
        jvmToolchain(21)
        jvmTarget(11)
        multiplatform {
            androidLibrary()
            jvm()
        }
    }
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
            }
        }
    }
}
