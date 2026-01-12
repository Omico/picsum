/*
 * Copyright 2024-2026 Omico. All Rights Reserved.
 */
package me.omico.picsum.api.di

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.Provides
import me.omico.picsum.api.PicsumService

@ContributesTo(AppScope::class)
interface MetroPicsumApiModule {
    @Provides
    fun providesPicsumService(): PicsumService =
        PicsumService()
}
