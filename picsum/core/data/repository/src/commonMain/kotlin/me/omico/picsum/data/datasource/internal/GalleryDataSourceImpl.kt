/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.datasource.internal

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.omico.picsum.data.database.dao.ImageDao
import me.omico.picsum.data.database.entity.Image
import me.omico.picsum.data.datasource.GalleryDataSource
import me.omico.picsum.data.mapper.toGalleryImage
import me.omico.picsum.data.model.GalleryImage
import me.omico.picsum.data.paging.ImagesRemoteMediator

internal class GalleryDataSourceImpl(
    private val imagesRemoteMediator: ImagesRemoteMediator,
    private val imageDao: ImageDao,
) : GalleryDataSource {
    override fun imagePagingDataFlow(pageSize: Int): Flow<PagingData<GalleryImage>> =
        createImagePager(pageSize).flow
            .map { pagingData -> pagingData.map(Image::toGalleryImage) }

    @OptIn(ExperimentalPagingApi::class)
    private fun createImagePager(pageSize: Int): Pager<Int, Image> =
        Pager(
            config = PagingConfig(
                pageSize = pageSize,
            ),
            remoteMediator = imagesRemoteMediator,
            pagingSourceFactory = imageDao::pagingSource,
        )
}
