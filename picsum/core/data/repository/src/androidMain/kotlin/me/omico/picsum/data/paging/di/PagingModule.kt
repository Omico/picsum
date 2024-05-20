/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.paging.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.omico.picsum.api.PicsumService
import me.omico.picsum.data.database.dao.ImageDao
import me.omico.picsum.data.paging.ImagesRemoteMediator
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object PagingModule {
    @Provides
    @Singleton
    fun providesImagesRemoteMediator(
        picsumService: PicsumService,
        imageDao: ImageDao,
    ): ImagesRemoteMediator =
        ImagesRemoteMediator(
            picsumService = picsumService,
            imageDao = imageDao,
        )
}
