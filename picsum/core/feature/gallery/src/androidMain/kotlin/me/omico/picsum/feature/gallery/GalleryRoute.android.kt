/*
 * Copyright 2025-2026 Omico. All Rights Reserved.
 */
package me.omico.picsum.feature.gallery

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import dev.zacsweers.metrox.viewmodel.metroViewModel
import me.omico.picsum.feature.gallery.api.GalleryRoute

actual fun EntryProviderScope<NavKey>.addGalleryRoute(): Unit =
    entry<GalleryRoute> {
        GalleryUi(viewModel = metroViewModel())
    }
