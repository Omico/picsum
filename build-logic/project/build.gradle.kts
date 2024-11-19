plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(androidx.room)
    implementation(com.google.dagger.hilt.android)
    implementation(consensusGradlePlugins)
    implementation(gradmGeneratedJar)
}

dependencies {
    implementation("me.omico.kami:kami-android")
    implementation("me.omico.kami:kami-compose")
    implementation("me.omico.kami:kami-core")
    implementation("me.omico.kami:kami-kotlin")
}
