/*
 * Copyright 2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.feature.gallery

import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import me.omico.picsum.data.datasource.GalleryDataSource

@HiltViewModel
internal actual class GalleryViewModel
    @Inject
    actual constructor(
        galleryDataSource: GalleryDataSource,
    ) : CommonGalleryViewModel(
            galleryDataSource = galleryDataSource,
        )
