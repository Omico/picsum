/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.gradle.project.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

abstract class PicsumTask : DefaultTask() {
    init {
        group = "picsum"
    }

    @TaskAction
    protected open fun execute(): Unit = Unit
}
