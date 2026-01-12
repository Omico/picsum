/*
 * Copyright 2026 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.datasource.di

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.Provides
import me.omico.picsum.data.database.dao.ImageDao
import me.omico.picsum.data.datasource.GalleryDataSource
import me.omico.picsum.data.datasource.internal.GalleryDataSourceImpl
import me.omico.picsum.data.paging.ImagesRemoteMediator

@ContributesTo(AppScope::class)
interface MetroDataSourcesModule {
    @Provides
    fun providesGalleryDataSource(
        imagesRemoteMediator: ImagesRemoteMediator,
        imageDao: ImageDao,
    ): GalleryDataSource =
        GalleryDataSourceImpl(
            imagesRemoteMediator = imagesRemoteMediator,
            imageDao = imageDao,
        )
}
