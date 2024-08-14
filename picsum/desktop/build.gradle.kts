plugins {
    kotlin("jvm")
    id("picsum.compose-multiplatform")
}

compose {
    desktop {
        application {
            mainClass = "me.omico.picsum.desktop.PicsumDesktop"
        }
    }
}

dependencies {
    implementation(project(":picsum-core-application"))
    implementation(kotlinx.coroutines.swing)
}
