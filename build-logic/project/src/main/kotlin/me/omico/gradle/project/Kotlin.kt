/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.gradle.project

import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import java.io.File

internal fun NamedDomainObjectContainer<KotlinSourceSet>.createSourcePackageDirectories(project: Project): Unit =
    configureEach { kotlin.srcDirs.filter(File::exists).forEach(project::createKotlinSourcePackageDirectories) }

private fun Project.createKotlinSourcePackageDirectories(sourceDirectory: File) {
    var paths = project.path.removePrefix(":").split('-').drop(1)
    if (paths.first() == "core") paths = paths.drop(1)
    paths = project.group.toString().split('.') + paths
    sourceDirectory.resolve(paths.joinToString("/")).mkdirs()
}
