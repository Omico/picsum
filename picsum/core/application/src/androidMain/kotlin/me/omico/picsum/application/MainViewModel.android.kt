/*
 * Copyright 2024-2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import me.omico.picsum.data.datasource.GalleryDataSource
import me.omico.picsum.data.model.GalleryImage
import javax.inject.Inject

@HiltViewModel
actual class MainViewModel @Inject constructor(
    private val galleryDataSource: GalleryDataSource,
) : ViewModel() {
    actual fun galleryImagePagingDataFlow(pageSize: Int): Flow<PagingData<GalleryImage>> =
        galleryDataSource.imagePagingDataFlow(pageSize).cachedIn(viewModelScope)
}
