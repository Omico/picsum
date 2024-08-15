/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.database.dao

import androidx.room.Dao
import me.omico.picsum.data.database.entity.Image

@Dao
expect interface ImageDao {
    suspend fun insertAll(images: List<Image>)
}
