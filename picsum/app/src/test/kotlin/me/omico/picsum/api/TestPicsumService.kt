/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.api

internal val testPicsumService: PicsumService = PicsumService()

internal val picsumServiceFirstTwoResults: PicsumImages =
    listOf(
        PicsumImage(
            id = "0",
            author = "Alejandro Escamilla",
            width = 5000,
            height = 3333,
            url = "https://unsplash.com/photos/yC-Yzbqy7PY",
            downloadUrl = "https://picsum.photos/id/0/5000/3333",
        ),
        PicsumImage(
            id = "1",
            author = "Alejandro Escamilla",
            width = 5000,
            height = 3333,
            url = "https://unsplash.com/photos/LNRyGwIJr5c",
            downloadUrl = "https://picsum.photos/id/1/5000/3333",
        ),
    )
