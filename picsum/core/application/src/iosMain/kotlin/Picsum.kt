/*
 * Copyright 2024-2025 Omico. All Rights Reserved.
 */
import androidx.compose.ui.window.ComposeUIViewController
import androidx.paging.compose.collectAsLazyPagingItems
import me.omico.picsum.application.MainViewModel
import me.omico.picsum.application.PicsumContainer
import platform.UIKit.UIViewController
import kotlin.experimental.ExperimentalObjCName

@Suppress("FunctionName")
@OptIn(ExperimentalObjCName::class)
@ObjCName("MainViewController")
fun MainViewController(): UIViewController {
    val viewModel = MainViewModel()
    val controller = ComposeUIViewController {
        PicsumContainer(
            lazyPagingGalleryImages = viewModel.galleryImagePagingDataFlow().collectAsLazyPagingItems(),
        )
    }
    return controller
}
