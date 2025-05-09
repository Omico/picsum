/*
 * Copyright 2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.feature.gallery

import androidx.compose.runtime.Immutable
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import me.omico.picsum.data.model.GalleryImage

@Immutable
data class GalleryUiState(
    val galleryImagePagingData: Flow<PagingData<GalleryImage>> = emptyFlow(),
    val eventSink: (GalleryUiEvent) -> Unit = {},
) {
    companion object {
        val Empty: GalleryUiState = GalleryUiState()
    }
}
