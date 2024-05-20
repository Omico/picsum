/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.datasource

import androidx.paging.Pager
import me.omico.picsum.data.database.entity.Image

interface GalleryDataSource {
    fun imagePager(pageSize: Int): Pager<Int, Image>
}
