/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.api

import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

suspend fun PicsumService.list(page: Int, limit: Int = DEFAULT_LIMIT): PicsumImages =
    httpClient.get("/v2/list?page=$page&limit=$limit").body()

@Serializable
data class PicsumImage(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    @SerialName("download_url") val downloadUrl: String,
)

typealias PicsumImages = List<PicsumImage>

private const val DEFAULT_LIMIT = 30
