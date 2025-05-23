/*
 * Copyright 2024-2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.feature.gallery

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import coil3.compose.AsyncImagePainter
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import coil3.request.ImageRequest
import coil3.request.crossfade
import me.omico.picsum.data.model.GalleryImage

@Composable
fun GalleryUi(
    uiState: GalleryUiState,
    lazyPagingGalleryImages: LazyPagingItems<GalleryImage>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(minSize = 200.dp),
        modifier = modifier,
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(space = 4.dp),
    ) {
        item(span = StaggeredGridItemSpan.FullLine) {
            Spacer(modifier = Modifier.windowInsetsTopHeight(WindowInsets.systemBars))
        }
        item(span = StaggeredGridItemSpan.FullLine) {
            AnimatedVisibility(visible = lazyPagingGalleryImages.loadState.refresh == LoadState.Loading) {
                Text(
                    text = "Loading...",
                    modifier = Modifier.wrapContentWidth(align = Alignment.CenterHorizontally),
                )
            }
        }
        items(
            count = lazyPagingGalleryImages.itemCount,
            key = lazyPagingGalleryImages.itemKey(key = GalleryImage::id),
        ) { index ->
            GalleryImageItem(
                image = lazyPagingGalleryImages[index] ?: return@items,
                modifier = Modifier.animateContentSize(),
            )
        }
        item(span = StaggeredGridItemSpan.FullLine) {
            AnimatedVisibility(visible = lazyPagingGalleryImages.loadState.append == LoadState.Loading) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                    content = { CircularProgressIndicator() },
                )
            }
        }
        item(span = StaggeredGridItemSpan.FullLine) {
            Spacer(modifier = Modifier.windowInsetsBottomHeight(WindowInsets.systemBars))
        }
    }
}

@Composable
fun GalleryImageItem(
    image: GalleryImage,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(size = 4.dp),
    ) {
        Box {
            val context = LocalPlatformContext.current
            val imageRequest = remember(image.downloadUrl) {
                ImageRequest.Builder(context)
                    .data(image.downloadUrl)
                    .crossfade(true)
                    .build()
            }
            val ratio = remember(image.width, image.height) { image.width.toFloat() / image.height.toFloat() }
            SubcomposeAsyncImage(
                model = imageRequest,
                contentDescription = null,
                modifier = Modifier.aspectRatio(ratio = ratio),
                contentScale = ContentScale.Fit,
            ) {
                val state by painter.state.collectAsState()
                when (state) {
                    is AsyncImagePainter.State.Empty,
                    is AsyncImagePainter.State.Loading,
                    is AsyncImagePainter.State.Error,
                    -> Box(contentAlignment = Alignment.Center) { CircularProgressIndicator() }

                    is AsyncImagePainter.State.Success -> SubcomposeAsyncImageContent()
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
