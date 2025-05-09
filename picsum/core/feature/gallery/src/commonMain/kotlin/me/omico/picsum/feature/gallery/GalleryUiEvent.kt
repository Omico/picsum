/*
 * Copyright 2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.feature.gallery

import androidx.compose.runtime.Immutable

@Immutable
sealed interface GalleryUiEvent {
    data class ChangePageSize(val size: Int) : GalleryUiEvent
}
