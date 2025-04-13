import me.omico.consensus.spotless.ConsensusSpotlessDefaults

plugins {
    id("me.omico.consensus.spotless")
}

consensus {
    spotless {
        kotlin(
            excludeTargets = ConsensusSpotlessDefaults.Kotlin.excludeTargets(
                "src/*/kotlin/androidx/**/*.kt",
            ),
            licenseHeaderFile = rootProject.file("spotless/copyright.kt").takeIf(File::exists),
        )
        kotlinGradle()
    }
}
