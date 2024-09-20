/*
 * Copyright 2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.application

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import me.omico.picsum.data.model.GalleryImage

actual class MainViewModel : ViewModel() {
    actual fun galleryImagePagingDataFlow(pageSize: Int): Flow<PagingData<GalleryImage>> = emptyFlow()
}
