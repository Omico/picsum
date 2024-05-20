/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.api.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.omico.picsum.api.PicsumService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object PicsumApiModule {
    @Provides
    @Singleton
    fun providesPicsumService(): PicsumService = PicsumService()
}
