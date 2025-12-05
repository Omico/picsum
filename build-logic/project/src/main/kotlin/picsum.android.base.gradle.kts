import me.omico.kami.android.dsl.onAndroidBaseApplied

onAndroidBaseApplied {
    namespace = "me.omico.${name.replace("-", ".")}"
    compileSdk = 36
    defaultConfig {
        minSdk = 30
    }
}

// https://github.com/gradle/gradle/issues/33619
tasks.withType<AbstractTestTask>().configureEach {
    failOnNoDiscoveredTests = false
}
