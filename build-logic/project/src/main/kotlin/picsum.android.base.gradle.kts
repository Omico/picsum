import me.omico.gradle.project.configureAndroidCommonExtension
import me.omico.gradm.dependency.DesugarJdkLibs

plugins {
    id("com.android.base")
    id("org.gradle.android.cache-fix")
}

// Android 11+
configureAndroidCommonExtension(
    domain = "me.omico",
    compileSdk = 35,
    minSdk = 30,
    coreLibraryDesugaringDependency = DesugarJdkLibs.nio,
)

plugins.withId("org.jetbrains.kotlin.plugin.compose") {
    configureAndroidCommonExtension {
        buildFeatures {
            compose = true
        }
    }
}
