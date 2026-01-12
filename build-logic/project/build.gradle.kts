plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(androidx.room)
    implementation(com.google.dagger.hilt.android)
    implementation(consensusGradlePlugins)
    implementation(dev.zacsweers.metro)
    implementation(gradmGeneratedJar)
    implementation(kamiAndroidPlugin)
    implementation(kamiComposePlugin)
    implementation(kamiKotlinPlugin)
}
