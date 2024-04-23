/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.omico.picsum.data.database.PicsumDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun providesPicsumDatabase(
        @ApplicationContext context: Context,
    ): PicsumDatabase = Room
        .databaseBuilder(
            context = context,
            klass = PicsumDatabase::class.java,
            name = "picsum-database",
        )
        .build()
}
