import me.omico.gradle.initialization.includeAllSubprojectModules
import me.omico.gradm.addDeclaredRepositories

addDeclaredRepositories()

plugins {
    id("picsum.develocity")
    id("picsum.gradm")
}

includeBuild("build-logic/project")

includeAllSubprojectModules("picsum")
