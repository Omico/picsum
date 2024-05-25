import me.omico.gradle.project.configureCommonAndroid

plugins {
    kotlin("plugin.compose")
    id("org.jetbrains.compose")
}

composeCompiler {
    metricsDestination = file("build/composeMetrics")
    reportsDestination = file("build/composeReports")
}

plugins.withId("com.android.base") {
    configureCommonAndroid {
        buildFeatures {
            compose = true
        }
    }
}
