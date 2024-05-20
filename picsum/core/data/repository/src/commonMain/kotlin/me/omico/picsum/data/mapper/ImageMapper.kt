/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.mapper

import me.omico.picsum.api.PicsumImage
import me.omico.picsum.api.PicsumImages
import me.omico.picsum.data.database.entity.Image
import me.omico.picsum.data.database.entity.Images
import me.omico.picsum.data.model.GalleryImage
import me.omico.picsum.data.model.GalleryImages

fun PicsumImage.toEntity(): Image =
    Image(
        id = id,
        author = author,
        width = width,
        height = height,
        url = url,
        downloadUrl = downloadUrl,
    )

fun PicsumImages.toEntities(): List<Image> = map(PicsumImage::toEntity)

fun Image.toGalleryImage(): GalleryImage =
    GalleryImage(
        id = id,
        author = author,
        width = width,
        height = height,
        url = url,
        downloadUrl = downloadUrl,
    )

fun Images.toGalleryImages(): GalleryImages = map(Image::toGalleryImage)
