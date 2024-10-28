import me.omico.gradle.project.kotlinSourcePackage
import me.omico.gradle.project.restrictComposeMultiplatformVersion
import me.omico.gradm.Versions

plugins {
    id("picsum.compose-compiler")
    id("org.jetbrains.compose")
}

restrictComposeMultiplatformVersion(version = Versions.compose.multiplatform)

compose {
    resources {
        packageOfResClass = "$kotlinSourcePackage.generated"
        generateResClass = never
    }
}
