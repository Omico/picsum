plugins {
    id("picsum.android.application")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
    id("androidx.room")
    kotlin("plugin.serialization")
}

android {
    namespace = "me.omico.picsum.android"
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs["debug"]
        }
    }
}

androidComponents {
    onVariants(selector().withBuildType("release")) { variant ->
        variant.packaging.resources.excludes.addAll(
            "DebugProbesKt.bin",
            "META-INF/*.version",
            "kotlin-tooling-metadata.json",
        )
    }
}

room {
    schemaDirectory("$projectDir/schemas")
}

dependencies {
    implementation(androidx.activity.compose)
    implementation(androidx.compose.foundation)
    implementation(androidx.compose.material3)
    implementation(androidx.compose.ui.tooling.preview)
    implementation(androidx.core.splashScreen)
    implementation(androidx.paging.compose)
    implementation(androidx.paging.runtime)
    implementation(androidx.room.ktx)
    implementation(androidx.room.paging)
    implementation(androidx.room.runtime)
    implementation(coil.compose)
    implementation(coil.network.ktor)
    implementation(delusion.logger)
    implementation(hilt.android)
    implementation(kotlinx.coroutines.android)
    implementation(kotlinx.serialization.json)
    implementation(ktor.client.content.negotiation)
    implementation(ktor.client.okhttp)
    implementation(ktor.serialization.kotlinx.json)
    implementation(okio)
    debugImplementation(androidx.compose.ui.tooling)
    ksp(androidx.room.compiler)
    ksp(hilt.android.compiler)
    testImplementation(kotlin("test"))
}
