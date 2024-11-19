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
        jvmToolchain(21)
        jvmTarget(11)
        compilerPlugins {
            serialization("1.7.3")
        }
    }
}

dependencies {
    kami {
        implementation(kotlinx.serialization.json)
        implementation(kotlinx.serialization.core("1.7.3"))
    }
}

afterEvaluate {
    logger.lifecycle("The current Kotlin version which is used by Kami is ${kami.kotlin.version}.")
}
