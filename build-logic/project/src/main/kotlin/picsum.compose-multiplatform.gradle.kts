import me.omico.gradle.project.kotlinSourcePackage

plugins {
    id("me.omico.kami.compose")
}

compose {
    resources {
        packageOfResClass = "$kotlinSourcePackage.generated"
        generateResClass = never
    }
}
