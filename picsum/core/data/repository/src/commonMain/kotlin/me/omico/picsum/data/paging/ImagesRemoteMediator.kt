/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import me.omico.picsum.api.PicsumService
import me.omico.picsum.api.list
import me.omico.picsum.data.database.dao.ImageDao
import me.omico.picsum.data.database.entity.Image
import me.omico.picsum.data.mapper.toEntities

@OptIn(ExperimentalPagingApi::class)
class ImagesRemoteMediator(
    private val picsumService: PicsumService,
    private val imageDao: ImageDao,
) : RemoteMediator<Int, Image>() {
    override suspend fun load(loadType: LoadType, state: PagingState<Int, Image>): MediatorResult =
        runCatching {
            val page = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND ->
                    state.lastItemOrNull()
                        ?.let { (it.id.toInt() + 1) / state.config.pageSize + 1 }
                        ?: return MediatorResult.Success(endOfPaginationReached = false)
            }
            val picsumImages = picsumService.list(
                page = page,
                limit = when (loadType) {
                    LoadType.REFRESH -> state.config.initialLoadSize
                    else -> state.config.pageSize
                },
            )
            imageDao.insertAll(picsumImages.toEntities())
            MediatorResult.Success(endOfPaginationReached = picsumImages.isEmpty())
        }.getOrElse { exception ->
            exception.printStackTrace()
            MediatorResult.Error(exception)
        }
}
