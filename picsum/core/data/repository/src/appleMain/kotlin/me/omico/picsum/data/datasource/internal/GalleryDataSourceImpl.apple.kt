/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.datasource.internal

import androidx.paging.Pager
import me.omico.picsum.data.database.entity.Image
import me.omico.picsum.data.datasource.GalleryDataSource

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING") // TODO KT-61573
internal actual class GalleryDataSourceImpl : GalleryDataSource {
    override fun imagePager(pageSize: Int): Pager<Int, Image> {
        TODO("Not yet implemented")
    }
}
