rootProject.name = "picsum-root"

pluginManagement {
    includeBuild("build-logic/initialization")
}

plugins {
    id("picsum")
}

includeBuild("../../OmicoDev/kami") {
    dependencySubstitution {
        substitute(module("me.omico.kami:kami-android")).using(project(":kami-android"))
        substitute(module("me.omico.kami:kami-compose")).using(project(":kami-compose"))
        substitute(module("me.omico.kami:kami-core")).using(project(":kami-core"))
        substitute(module("me.omico.kami:kami-kotlin")).using(project(":kami-kotlin"))
    }
}
