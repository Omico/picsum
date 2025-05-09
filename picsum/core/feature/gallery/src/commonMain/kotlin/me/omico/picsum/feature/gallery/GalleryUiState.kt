/*
 * Copyright 2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.feature.gallery

import androidx.compose.runtime.Immutable

@Immutable
data class GalleryUiState(
    val pageSize: Int = DEFAULT_PAGE_SIZE,
    val eventSink: (GalleryUiEvent) -> Unit = {},
) {
    companion object {
        val Empty: GalleryUiState = GalleryUiState()
    }
}
