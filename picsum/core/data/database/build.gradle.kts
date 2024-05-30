plugins {
    id("picsum.kotlin.multiplatform.library.hilt")
    id("androidx.room")
    id("dev.omico.roommate")
    id("com.google.devtools.ksp")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":picsum-core-foundation"))
            }
        }
    }
}

room {
    schemaDirectory("$projectDir/schemas")
}

roommate {
    roomVersion(versions.androidx.room)
    dependencies {
        commonMainImplementation(roomPaging)
        desktopMainImplementation(sqliteBundle)
    }
    dependencies {
        kspAndroid(roomCompiler)
        kspDesktop(roomCompiler)
    }
}
