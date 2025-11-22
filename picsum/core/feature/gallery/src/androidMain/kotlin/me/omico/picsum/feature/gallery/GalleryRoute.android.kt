package me.omico.picsum.feature.gallery

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey

actual fun EntryProviderScope<NavKey>.addGalleryRoute(): Unit =
    entry<GalleryRoute> {
        val galleryDataSource = LocalGalleryDataSource.current
        GalleryUi(
            viewModel = viewModel {
                GalleryViewModel(
                    galleryDataSource = galleryDataSource,
                )
            }
        )
    }
