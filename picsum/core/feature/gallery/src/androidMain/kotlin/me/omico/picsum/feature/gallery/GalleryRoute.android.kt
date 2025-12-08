package me.omico.picsum.feature.gallery

import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey

actual fun EntryProviderScope<NavKey>.addGalleryRoute(): Unit =
    entry<GalleryRoute> {
        GalleryUi(viewModel = hiltViewModel())
    }
