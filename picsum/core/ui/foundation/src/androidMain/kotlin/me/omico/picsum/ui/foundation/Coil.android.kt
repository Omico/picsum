/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.ui.foundation

import coil3.ImageLoader
import coil3.util.DebugLogger
import me.omico.picsum.core.ui.foundation.BuildConfig

@Suppress("NOTHING_TO_INLINE")
internal actual inline fun ImageLoader.Builder.applyCoilDebugLogger(): ImageLoader.Builder =
    apply { if (BuildConfig.DEBUG) logger(DebugLogger()) }
