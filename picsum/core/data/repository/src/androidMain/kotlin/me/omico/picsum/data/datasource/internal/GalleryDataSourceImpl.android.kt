/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.datasource.internal

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import me.omico.picsum.data.database.dao.ImageDao
import me.omico.picsum.data.database.entity.Image
import me.omico.picsum.data.datasource.GalleryDataSource
import me.omico.picsum.data.paging.ImagesRemoteMediator

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING") // TODO KT-61573
internal actual class GalleryDataSourceImpl(
    private val imagesRemoteMediator: ImagesRemoteMediator,
    private val imageDao: ImageDao,
) : GalleryDataSource {
    @OptIn(ExperimentalPagingApi::class)
    override fun imagePager(pageSize: Int): Pager<Int, Image> =
        Pager(
            config = PagingConfig(
                pageSize = pageSize,
            ),
            remoteMediator = imagesRemoteMediator,
            pagingSourceFactory = imageDao::pagingSource,
        )
}
