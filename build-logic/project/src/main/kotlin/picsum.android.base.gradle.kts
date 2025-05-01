import me.omico.kami.android.dsl.onAndroidBaseApplied

onAndroidBaseApplied {
    namespace = "me.omico.${name.replace("-", ".")}"
    compileSdk = 35
    defaultConfig {
        minSdk = 30
    }
}
