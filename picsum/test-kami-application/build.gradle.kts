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
        withSerialization("1.7.3")
    }
}

println("The current Kotlin version which is used by Kami is ${kami.kotlin.version}.")

dependencies {
    with(kami) {
        implementation(kotlinx.serialization.json)
        implementation(kotlinx.serialization.core("1.7.3"))
    }
}
