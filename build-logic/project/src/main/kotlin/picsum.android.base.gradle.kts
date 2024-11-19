import me.omico.kami.android.dsl.configureAndroidCommonExtension

plugins {
    id("me.omico.kami.android.base")
}

configureAndroidCommonExtension {
    namespace = "me.omico.${name.replace("-", ".")}"
    compileSdk = 35
    defaultConfig {
        minSdk = 30
    }
    // TODO Configure by Kami Kotlin Plugin
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kami {
    android {
        coreLibraryDesugaring("com.android.tools:desugar_jdk_libs_nio:2.1.2")
    }
}
