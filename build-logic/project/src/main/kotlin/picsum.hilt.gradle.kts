import me.omico.gradle.project.configureHilt

plugins {
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

configureHilt()
