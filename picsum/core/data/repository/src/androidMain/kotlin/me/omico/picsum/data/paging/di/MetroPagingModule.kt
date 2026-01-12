/*
 * Copyright 2026 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.paging.di

import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.Provides
import me.omico.picsum.api.PicsumService
import me.omico.picsum.data.database.dao.ImageDao
import me.omico.picsum.data.paging.ImagesRemoteMediator

@ContributesTo(AppScope::class)
interface MetroPagingModule {
    @Provides
    fun providesImagesRemoteMediator(
        picsumService: PicsumService,
        imageDao: ImageDao,
    ): ImagesRemoteMediator =
        ImagesRemoteMediator(
            picsumService = picsumService,
            imageDao = imageDao,
        )
}
