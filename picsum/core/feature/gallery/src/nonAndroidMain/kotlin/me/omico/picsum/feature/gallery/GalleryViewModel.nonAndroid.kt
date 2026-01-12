/*
 * Copyright 2025-2026 Omico. All Rights Reserved.
 */
package me.omico.picsum.feature.gallery

import androidx.lifecycle.ViewModel
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesIntoMap
import dev.zacsweers.metro.Inject
import dev.zacsweers.metro.binding
import dev.zacsweers.metrox.viewmodel.ViewModelKey
import me.omico.picsum.data.datasource.GalleryDataSource

@Inject
@ViewModelKey(GalleryViewModel::class)
@ContributesIntoMap(
    scope = AppScope::class,
    binding = binding<ViewModel>(),
)
actual class GalleryViewModel actual constructor(
    galleryDataSource: GalleryDataSource,
) : CommonGalleryViewModel(galleryDataSource = galleryDataSource)
