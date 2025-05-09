/*
 * Copyright 2024-2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import dagger.hilt.android.AndroidEntryPoint
import me.omico.picsum.application.PicsumContainer
import me.omico.picsum.feature.gallery.GalleryViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: GalleryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val lazyPagingGalleryImages = viewModel.galleryImagePagingData.collectAsLazyPagingItems()
            PicsumContainer(
                galleryUiState = uiState,
                lazyPagingGalleryImages = lazyPagingGalleryImages,
            )
        }
    }
}
