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
    implementation(project(":picsum-core-application"))
    implementation(androidx.activity.compose)
    implementation(androidx.core.splashScreen)
    implementation(delusion.logger)
    implementation(kotlinx.coroutines.android)
    debugImplementation(compose.uiTooling)
}
