/*
 * Copyright 2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.feature.gallery

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

expect class GalleryViewModel : ViewModel {
    val uiState: StateFlow<GalleryUiState>
}

internal const val DEFAULT_PAGE_SIZE: Int = 10
