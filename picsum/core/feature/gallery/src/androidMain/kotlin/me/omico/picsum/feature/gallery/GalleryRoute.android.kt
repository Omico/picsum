/*
 * Copyright 2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.feature.gallery

import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import me.omico.picsum.feature.gallery.api.GalleryRoute

actual fun EntryProviderScope<NavKey>.addGalleryRoute(): Unit =
    entry<GalleryRoute> {
        GalleryUi(viewModel = hiltViewModel())
    }
