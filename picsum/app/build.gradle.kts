plugins {
    id("picsum.android.application")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
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

dependencies {
    implementation(project(":picsum-core-data"))
    implementation(androidx.activity.compose)
    implementation(androidx.compose.foundation)
    implementation(androidx.compose.material3)
    implementation(androidx.compose.ui.tooling.preview)
    implementation(androidx.core.splashScreen)
    implementation(androidx.paging.compose)
    implementation(coil.compose)
    implementation(coil.network.ktor)
    implementation(delusion.logger)
    implementation(hilt.android)
    implementation(kotlinx.coroutines.android)
    debugImplementation(androidx.compose.ui.tooling)
    ksp(hilt.android.compiler)
}
