/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import me.omico.picsum.data.database.entity.Image

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING") // TODO KT-61573
@Dao
actual interface ImageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    actual suspend fun insertAll(images: List<Image>)

    @Query("SELECT * FROM images")
    fun pagingSource(): PagingSource<Int, Image>
}
