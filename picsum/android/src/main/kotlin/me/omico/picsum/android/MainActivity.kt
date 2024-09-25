/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.paging.compose.collectAsLazyPagingItems
import dagger.hilt.android.AndroidEntryPoint
import me.omico.picsum.ui.PicsumContainer

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            PicsumContainer(
                lazyPagingGalleryImages = viewModel.galleryImagePagingDataFlow().collectAsLazyPagingItems(),
            )
        }
    }
}
