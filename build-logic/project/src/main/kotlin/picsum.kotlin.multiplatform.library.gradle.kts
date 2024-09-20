plugins {
    id("picsum.android.base")
    id("picsum.kotlin.multiplatform.base")
}

kami {
    kotlin {
        multiplatform {
            androidLibrary()
            jvmDesktop()
        }
    }
}

kotlin {
    iosArm64()
    iosSimulatorArm64()
}
