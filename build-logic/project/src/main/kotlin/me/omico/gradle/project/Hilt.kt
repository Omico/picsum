/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.gradle.project

import me.omico.gradm.dependency.Hilt
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureHilt() {
    dependencies {
        when {
            plugins.hasPlugin("org.jetbrains.kotlin.android") -> {
                add("implementation", Hilt.android)
                add("ksp", Hilt.android.compiler)
            }
            plugins.hasPlugin("org.jetbrains.kotlin.multiplatform") -> {
                add("androidMainImplementation", Hilt.android)
                add("kspAndroid", Hilt.android.compiler)
            }
        }
    }
}
