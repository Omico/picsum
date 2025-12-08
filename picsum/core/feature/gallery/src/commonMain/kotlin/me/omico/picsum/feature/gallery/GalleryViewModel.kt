/*
 * Copyright 2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.feature.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import me.omico.picsum.data.datasource.GalleryDataSource
import me.omico.picsum.data.model.GalleryImage

internal expect class GalleryViewModel(
    galleryDataSource: GalleryDataSource,
) : CommonGalleryViewModel

internal abstract class CommonGalleryViewModel(
    private val galleryDataSource: GalleryDataSource,
) : ViewModel() {
    private val pagingPageSize: MutableStateFlow<Int> = MutableStateFlow(DEFAULT_PAGE_SIZE)

    val uiState: StateFlow<GalleryUiState> =
        pagingPageSize
            .map { pageSize ->
                GalleryUiState(
                    pageSize = pageSize,
                    eventSink = { event ->
                        when (event) {
                            is GalleryUiEvent.ChangePageSize -> pagingPageSize.value = event.size
                        }
                    },
                )
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.Lazily,
                initialValue = GalleryUiState.Empty,
            )

    @OptIn(ExperimentalCoroutinesApi::class)
    val galleryImagePagingData: Flow<PagingData<GalleryImage>> =
        pagingPageSize.flatMapLatest(galleryDataSource::imagePagingDataFlow)
}

internal const val DEFAULT_PAGE_SIZE: Int = 10
