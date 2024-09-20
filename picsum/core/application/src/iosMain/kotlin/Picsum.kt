/*
 * Copyright 2024-2025 Omico. All Rights Reserved.
 */
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.ComposeUIViewController
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import me.omico.picsum.application.PicsumContainer
import me.omico.picsum.feature.gallery.GalleryViewModel
import platform.UIKit.UIViewController
import kotlin.experimental.ExperimentalObjCName

@Suppress("FunctionName")
@OptIn(ExperimentalObjCName::class)
@ObjCName("MainViewController")
fun MainViewController(): UIViewController {
    val viewModel = GalleryViewModel()
    val controller = ComposeUIViewController {
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val lazyPagingGalleryImages = viewModel.galleryImagePagingData.collectAsLazyPagingItems()
        PicsumContainer(
            galleryUiState = uiState,
            lazyPagingGalleryImages = lazyPagingGalleryImages,
        )
    }
    return controller
}
