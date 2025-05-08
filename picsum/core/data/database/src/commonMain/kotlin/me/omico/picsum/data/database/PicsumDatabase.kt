/*
 * Copyright 2024-2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import me.omico.picsum.data.database.dao.ImageDao
import me.omico.picsum.data.database.entity.Image

@Database(
    entities = [
        Image::class,
    ],
    version = 1,
)
@ConstructedBy(PicsumDatabaseConstructor::class)
abstract class PicsumDatabase : RoomDatabase() {
    abstract val imageDao: ImageDao
}
