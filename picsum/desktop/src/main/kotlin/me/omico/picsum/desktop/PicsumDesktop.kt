@file:JvmName("PicsumDesktop")

package me.omico.picsum.desktop

import androidx.compose.ui.window.singleWindowApplication
import androidx.paging.compose.collectAsLazyPagingItems
import me.omico.picsum.application.MainViewModel
import me.omico.picsum.application.PicsumContainer

fun main() {
    val viewModel = MainViewModel()
    singleWindowApplication {
        PicsumContainer(
            lazyPagingGalleryImages = viewModel.galleryImagePagingDataFlow().collectAsLazyPagingItems(),
        )
    }
}
