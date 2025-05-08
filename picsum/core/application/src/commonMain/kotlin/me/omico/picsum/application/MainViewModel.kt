/*
 * Copyright 2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.application

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.omico.picsum.data.model.GalleryImage

expect class MainViewModel : ViewModel {
    fun galleryImagePagingDataFlow(
        @Suppress("unused") pageSize: Int = DEFAULT_PAGE_SIZE,
    ): Flow<PagingData<GalleryImage>>
}

internal const val DEFAULT_PAGE_SIZE: Int = 10
