/*
 * Copyright 2026 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.database.di

import android.content.Context
import androidx.room.Room
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.Provides
import me.omico.picsum.data.database.PicsumDatabase
import me.omico.picsum.data.database.dao.ImageDao

@ContributesTo(AppScope::class)
interface MetroDaosModule {
    @Provides
    fun providesImageDao(database: PicsumDatabase): ImageDao =
        database.imageDao
}

@ContributesTo(AppScope::class)
interface MetroDatabaseModule {
    @Provides
    fun providesPicsumDatabase(context: Context): PicsumDatabase =
        Room
            .databaseBuilder<PicsumDatabase>(
                context = context,
                name = "picsum-database",
            ).build()
}
