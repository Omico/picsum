/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.omico.picsum.data.database.entity.Image
import me.omico.picsum.feature.gallery.GalleryUi
import me.omico.picsum.ui.foundation.SetupCoil

@Composable
fun PicsumContainer(
    imagePagingDataFlow: Flow<PagingData<Image>>,
) {
    MaterialTheme {
        SetupCoil()
        GalleryUi(
            imagePagingDataFlow = imagePagingDataFlow,
            modifier = Modifier.fillMaxSize(),
        )
    }
}
