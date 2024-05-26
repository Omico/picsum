/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "images",
    indices = [
        Index(value = ["id"], unique = true),
    ],
)
data class Image(
    @PrimaryKey val id: Int,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    @ColumnInfo(name = "download_url") val downloadUrl: String,
)

typealias Images = List<Image>
