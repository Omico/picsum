import me.omico.gradle.project.kotlinSourcePackage

plugins {
    id("me.omico.kami.compose")
}

kami {
    compose {
        restrictVersion()
    }
}

compose {
    resources {
        packageOfResClass = "$kotlinSourcePackage.generated"
        generateResClass = never
    }
}
