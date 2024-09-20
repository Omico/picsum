/*
 * Copyright 2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.feature.gallery

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import me.omico.picsum.data.model.GalleryImage

actual class GalleryViewModel : ViewModel() {
    actual val uiState: StateFlow<GalleryUiState> = MutableStateFlow(GalleryUiState.Empty).asStateFlow()
    actual val galleryImagePagingData: Flow<PagingData<GalleryImage>> = emptyFlow()
}
