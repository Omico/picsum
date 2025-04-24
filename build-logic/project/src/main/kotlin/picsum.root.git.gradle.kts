import me.omico.consensus.api.dsl.requireRootProject

plugins {
    id("me.omico.consensus.git")
}

requireRootProject()

consensus {
    git {
        hooks {
            preCommit {
                appendLine("#!/bin/sh")
                appendLine()
                correctGradleWrapperScriptPermissions()
                appendLine()
                checkGitAttributes()
                appendLine()
            }
        }
    }
}
