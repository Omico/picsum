/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.datasource.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.omico.picsum.data.database.dao.ImageDao
import me.omico.picsum.data.datasource.GalleryDataSource
import me.omico.picsum.data.datasource.internal.GalleryDataSourceImpl
import me.omico.picsum.data.paging.ImagesRemoteMediator
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataSourcesModule {
    @Provides
    @Singleton
    fun providesGalleryDataSource(
        imagesRemoteMediator: ImagesRemoteMediator,
        imageDao: ImageDao,
    ): GalleryDataSource =
        GalleryDataSourceImpl(
            imagesRemoteMediator = imagesRemoteMediator,
            imageDao = imageDao,
        )
}
