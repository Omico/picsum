import me.omico.kami.android.dsl.onAndroidBaseApplied

onAndroidBaseApplied {
    namespace = "me.omico.${name.replace("-", ".")}"
    compileSdk = 36
    defaultConfig {
        minSdk = 30
    }
}
