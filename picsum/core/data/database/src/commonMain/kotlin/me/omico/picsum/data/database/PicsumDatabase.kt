/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.database

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
abstract class PicsumDatabase : RoomDatabase() {
    abstract val imageDao: ImageDao
}
