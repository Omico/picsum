plugins {
    id("picsum.android.base")
    id("picsum.kotlin.multiplatform.base")
    id("picsum.dehell")
}

kami {
    kotlin {
        multiplatform {
            androidLibrary()
            jvmDesktop()
        }
    }
}

dehell {
    variant = "desktop"
}
