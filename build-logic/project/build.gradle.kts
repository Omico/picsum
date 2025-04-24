plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(androidGradlePlugin)
    implementation(androidx.room)
    implementation(com.google.dagger.hilt.android)
    implementation(com.google.devtools.ksp)
    implementation(consensusGradlePlugins)
    implementation(gradmGeneratedJar)
    implementation(kotlinGradlePlugin)
    implementation(org.jetbrains.compose)
    implementation(org.jetbrains.kotlin.plugin.compose)
}
