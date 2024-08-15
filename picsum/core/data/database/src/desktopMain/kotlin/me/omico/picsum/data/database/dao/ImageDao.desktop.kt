/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import me.omico.picsum.data.database.entity.Image

@Dao
actual interface ImageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    actual suspend fun insertAll(images: List<Image>)
}
