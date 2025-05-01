plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(androidx.room)
    implementation(com.google.dagger.hilt.android)
    implementation(consensusGradlePlugins)
    implementation(gradmGeneratedJar)
    implementation(kamiAndroidPlugin)
    implementation(kamiComposePlugin)
    implementation(kamiKotlinPlugin)
}
