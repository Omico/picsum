import me.omico.gradle.project.PROJECT_JAVA_VERSION
import me.omico.gradle.project.createDefaultSourcePackageDirectories

plugins {
    kamiKotlinMultiplatform
}

kotlin {
    sourceSets {
        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        if (!path.startsWith(":picsum-androidx-")) {
            createDefaultSourcePackageDirectories(project)
        }
    }
}

kami {
    kotlin {
        jvmToolchain(PROJECT_JAVA_VERSION)
        allWarningsAsErrors()
        enableExpectActualClasses()
    }
}
