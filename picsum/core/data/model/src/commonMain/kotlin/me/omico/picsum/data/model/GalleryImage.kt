/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.model

data class GalleryImage(
    val id: Int,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val downloadUrl: String,
)

typealias GalleryImages = List<GalleryImage>
