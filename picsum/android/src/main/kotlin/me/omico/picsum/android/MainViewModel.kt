/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.android

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
class MainViewModel @Inject constructor(
    galleryDataSource: GalleryDataSource,
) : ViewModel() {
    val galleryImagePagingDataFlow: Flow<PagingData<GalleryImage>> =
        galleryDataSource.imagePagingDataFlow(DEFAULT_PAGE_SIZE).cachedIn(viewModelScope)
}

private const val DEFAULT_PAGE_SIZE: Int = 10
