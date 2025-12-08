/*
 * Copyright 2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.feature.gallery

import me.omico.picsum.data.datasource.GalleryDataSource

internal actual class GalleryViewModel actual constructor(
    galleryDataSource: GalleryDataSource,
) : CommonGalleryViewModel(galleryDataSource = galleryDataSource)
