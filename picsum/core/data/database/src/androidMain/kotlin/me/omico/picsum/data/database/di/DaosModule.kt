/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.omico.picsum.data.database.PicsumDatabase
import me.omico.picsum.data.database.dao.ImageDao

@Module
@InstallIn(SingletonComponent::class)
internal object DaosModule {
    @Provides
    fun providesImageDao(
        database: PicsumDatabase,
    ): ImageDao = database.imageDao
}
