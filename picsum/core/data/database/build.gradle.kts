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
            dependencies {
                implementation(androidx.paging.common)
            }
        }
    }
}

room {
    schemaDirectory("$projectDir/schemas")
}

roommate {
    roomVersion(versions.androidx.room)
    withKspRoomCompiler()
    dependencies {
        commonMainImplementation(roomPaging)
        desktopMainImplementation(sqliteBundle)
    }
}
