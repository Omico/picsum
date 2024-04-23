import me.omico.gradle.project.configureCommonAndroid

plugins {
    id("com.android.base")
    id("org.gradle.android.cache-fix")
}

// Android 11+
configureCommonAndroid(
    domain = "me.omico",
    compileSdk = 34,
    minSdk = 30,
)
