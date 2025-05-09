/*
 * Copyright 2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.feature.gallery

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import me.omico.picsum.data.model.GalleryImage

expect class GalleryViewModel : ViewModel {
    val uiState: StateFlow<GalleryUiState>
    val galleryImagePagingData: Flow<PagingData<GalleryImage>>
}

internal const val DEFAULT_PAGE_SIZE: Int = 10
