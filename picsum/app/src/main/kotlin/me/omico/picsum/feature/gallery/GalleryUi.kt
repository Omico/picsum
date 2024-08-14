/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.feature.gallery

import android.graphics.drawable.ColorDrawable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import coil3.compose.AsyncImagePainter
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.placeholder
import kotlinx.coroutines.flow.Flow
import me.omico.picsum.data.database.entity.Image

@Composable
fun GalleryUi(
    imagePagingDataFlow: Flow<PagingData<Image>>,
    modifier: Modifier = Modifier,
) {
    val lazyPagingItems = imagePagingDataFlow.collectAsLazyPagingItems()
    Column(modifier = modifier) {
        AnimatedVisibility(visible = lazyPagingItems.loadState.refresh == LoadState.Loading) {
            Text(
                text = "Loading...",
                modifier = run {
                    Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                },
            )
        }
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(minSize = 200.dp),
            modifier = modifier,
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(space = 4.dp),
        ) {
            items(
                count = lazyPagingItems.itemCount,
                key = lazyPagingItems.itemKey(key = Image::id),
            ) { index ->
                ImageItem(
                    image = lazyPagingItems[index] ?: return@items,
                    modifier = Modifier.animateContentSize(),
                )
            }
        }
        AnimatedVisibility(visible = lazyPagingItems.loadState.append == LoadState.Loading) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator()
            }
        }
    }
}

@Composable
fun ImageItem(
    image: Image,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(size = 4.dp),
    ) {
        Box {
            val context = LocalContext.current
            val imageRequest = remember(image.downloadUrl) {
                ImageRequest.Builder(context)
                    .data(image.downloadUrl)
                    .placeholder(ColorDrawable(Color.LightGray.toArgb()))
                    .crossfade(true)
                    .build()
            }
            val ratio by remember {
                derivedStateOf { image.width.toFloat() / image.height.toFloat() }
            }
            SubcomposeAsyncImage(
                model = imageRequest,
                contentDescription = null,
                modifier = Modifier.aspectRatio(ratio = ratio),
                contentScale = ContentScale.Crop,
            ) {
                val state by painter.state.collectAsState()
                when (state) {
                    is AsyncImagePainter.State.Empty,
                    is AsyncImagePainter.State.Loading,
                    is AsyncImagePainter.State.Error,
                    -> {
                        Box(
                            contentAlignment = Alignment.Center,
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                    is AsyncImagePainter.State.Success -> {
                        SubcomposeAsyncImageContent()
                    }
                }
            }
            Box(
                modifier = run {
                    Modifier
                        .background(color = MaterialTheme.colorScheme.surfaceDim.copy(alpha = 0.7f))
                        .fillMaxWidth()
                        .align(alignment = Alignment.BottomStart)
                },
            ) {
                Text(
                    text = image.author,
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                )
            }
        }
    }
}
