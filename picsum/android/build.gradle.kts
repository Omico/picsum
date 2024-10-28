plugins {
    id("picsum.android.application")
    id("picsum.compose-multiplatform")
    id("picsum.hilt")
}

android {
    defaultConfig {
        targetSdk = 35
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

androidComponents {
    onVariants(selector().withBuildType("release")) { variant ->
        variant.packaging.resources.excludes.addAll(
            "DebugProbesKt.bin",
            "META-INF/**/LICENSE.txt",
            "META-INF/*.version",
            "META-INF/NOTICE.md",
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
