import me.omico.gradle.project.configureAndroidCommonExtension

plugins {
    id("com.android.base")
}

// Android 11+
configureAndroidCommonExtension(
    domain = "me.omico",
    compileSdk = 35,
    minSdk = 30,
)

plugins.withId("org.jetbrains.kotlin.plugin.compose") {
    configureAndroidCommonExtension {
        buildFeatures {
            compose = true
        }
    }
}
