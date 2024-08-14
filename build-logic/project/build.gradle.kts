plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(androidGradlePlugin)
    implementation(androidx.room)
    implementation(com.diffplug.spotless)
    implementation(com.google.dagger.hilt.android)
    implementation(com.google.devtools.ksp)
    implementation(gradmGeneratedJar)
    implementation(kotlinGradlePlugin)
    implementation(consensusGradlePlugins)
    implementation(org.gradle.android.cacheFix)
    implementation(org.jetbrains.kotlin.plugin.compose)
}
