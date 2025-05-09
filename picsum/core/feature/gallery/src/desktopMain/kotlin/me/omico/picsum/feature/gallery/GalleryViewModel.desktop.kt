/*
 * Copyright 2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.feature.gallery

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

actual class GalleryViewModel : ViewModel() {
    actual val uiState: StateFlow<GalleryUiState> = MutableStateFlow(GalleryUiState.Empty).asStateFlow()
}
