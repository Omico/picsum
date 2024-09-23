import me.omico.consensus.api.dsl.consensus
import me.omico.consensus.api.dsl.requireRootProject
import me.omico.gradle.project.task.FetchAndroidx
import me.omico.gradle.project.task.SyncAndroidx

requireRootProject()

val fetchAndroidx: FetchAndroidx by tasks.register<FetchAndroidx>("fetchAndroidx") {
    val androidxDirectory = rootProject.consensus.localProperties.getOrNull<File>("ANDROIDX_DIRECTORY")
    enabled = androidxDirectory != null
    androidxDirectoryProperty = androidxDirectory
    // https://developer.android.com/jetpack/androidx/releases/paging#3.3.2
    commitIdProperty = "1c46a8d0eefa9cf9c4b07e28ebd88a0d737a0508"
}

val syncAndroidx: SyncAndroidx by tasks.register<SyncAndroidx>("syncAndroidx") {
    enabled = fetchAndroidx.enabled
    androidxDirectoryProperty = fetchAndroidx.androidxDirectoryProperty
    copySpecsProperty = listOf(
        SyncAndroidx.CopySpec(
            sourcePath = "paging/paging-compose",
            targetPath = "picsum/androidx/paging/compose",
        ),
    )
}
