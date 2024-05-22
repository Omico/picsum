/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.gradle.project

import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.kotlin.dsl.assign
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension

internal fun Project.configureComposeCompiler(): Unit =
    composeCompiler {
        metricsDestination = file("build/composeMetrics")
        reportsDestination = file("build/composeReports")
    }

private fun Project.composeCompiler(configure: Action<ComposeCompilerGradlePluginExtension>): Unit =
    extensions.configure("composeCompiler", configure)
