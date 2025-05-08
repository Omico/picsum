/*
 * Copyright 2024-2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.application

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import me.omico.picsum.data.model.GalleryImage
import me.omico.picsum.feature.gallery.GalleryUi
import me.omico.picsum.ui.foundation.SetupCoil

@Composable
fun PicsumContainer(
    lazyPagingGalleryImages: LazyPagingItems<GalleryImage>,
) {
    MaterialTheme {
        SetupCoil()
        GalleryUi(
            lazyPagingGalleryImages = lazyPagingGalleryImages,
            modifier = Modifier.fillMaxSize(),
        )
    }
}
