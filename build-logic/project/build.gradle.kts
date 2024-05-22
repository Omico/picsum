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
    implementation(me.omico.consensus.api)
    implementation(me.omico.consensus.dsl)
    implementation(me.omico.consensus.git)
    implementation(me.omico.consensus.spotless)
    implementation(org.gradle.android.cacheFix)
    implementation(org.jetbrains.kotlin.plugin.compose)
}
