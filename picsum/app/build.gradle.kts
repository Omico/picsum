plugins {
    id("picsum.android.application")
    id("picsum.hilt")
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
    implementation(kotlinx.coroutines.android)
    debugImplementation(androidx.compose.ui.tooling)
}
