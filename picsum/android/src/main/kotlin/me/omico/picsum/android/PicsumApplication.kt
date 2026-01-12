/*
 * Copyright 2024-2026 Omico. All Rights Reserved.
 */
package me.omico.picsum.android

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Provides
import dev.zacsweers.metro.createGraphFactory
import dev.zacsweers.metrox.android.MetroAppComponentProviders
import dev.zacsweers.metrox.android.MetroApplication
import dev.zacsweers.metrox.viewmodel.ViewModelGraph

@HiltAndroidApp
class PicsumApplication :
    Application(),
    MetroApplication {
    override val appComponentProviders: MetroAppComponentProviders by lazy {
        createGraphFactory<AppGraph.Factory>().create(this)
    }
}

@DependencyGraph(AppScope::class)
interface AppGraph :
    MetroAppComponentProviders,
    ViewModelGraph {
    @Provides
    fun provideApplicationContext(application: Application): Context =
        application

    @DependencyGraph.Factory
    fun interface Factory {
        fun create(
            @Provides application: Application,
        ): AppGraph
    }
}
