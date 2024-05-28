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
        commonMain {
            dependencies {
                implementation(androidx.room.paging)
            }
        }
    }
}

room {
    schemaDirectory("$projectDir/schemas")
}

roommate {
    roomVersion(versions.androidx.room)
    withKsp("android", "desktop")
    applySqliteBundleTo("desktopMainImplementation")
}
