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
        multiplatform {
            androidLibrary()
            jvm()
        }
    }
}
