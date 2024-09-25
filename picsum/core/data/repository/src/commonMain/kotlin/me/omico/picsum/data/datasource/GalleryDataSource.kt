/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.datasource

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.omico.picsum.data.model.GalleryImage

interface GalleryDataSource {
    fun imagePagingDataFlow(pageSize: Int): Flow<PagingData<GalleryImage>>
}
