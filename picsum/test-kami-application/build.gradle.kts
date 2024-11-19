plugins {
    id("me.omico.kami.kotlin.android")
    id("me.omico.kami.android.application")
    id("picsum.android.base")
}

kami {
    android {
        application {
        }
    }
    kotlin {
        jvmToolchain(11)
    }
}
