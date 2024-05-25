/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.ui.foundation

import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import coil3.memory.MemoryCache
import coil3.request.crossfade

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SetupCoil() {
    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context)
            .memoryCache {
                MemoryCache.Builder()
                    .maxSizePercent(context, percent = 0.25)
                    .build()
            }
            .crossfade(true)
            .applyCoilDebugLogger()
            .build()
    }
}

internal expect inline fun ImageLoader.Builder.applyCoilDebugLogger(): ImageLoader.Builder
