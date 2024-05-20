import me.omico.gradm.dependency.Hilt

plugins {
    id("picsum.kotlin.multiplatform.library")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

dependencies {
    add("androidMainImplementation", Hilt.android)
    add("kspAndroid", Hilt.android.compiler)
}
