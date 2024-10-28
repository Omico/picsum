plugins {
    kotlin("plugin.compose")
}

composeCompiler {
    metricsDestination = layout.buildDirectory.dir("composeMetrics")
    reportsDestination = layout.buildDirectory.dir("composeReports")
}
