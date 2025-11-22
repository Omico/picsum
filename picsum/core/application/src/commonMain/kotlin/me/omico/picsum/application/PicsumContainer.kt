/*
 * Copyright 2024-2025 Omico. All Rights Reserved.
 */
package me.omico.picsum.application

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.plus
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import me.omico.picsum.data.datasource.GalleryDataSource
import me.omico.picsum.feature.gallery.GalleryRoute
import me.omico.picsum.feature.gallery.addGalleryRoute
import me.omico.picsum.feature.gallery.rememberGalleryDataSourceNavEntryDecorator
import me.omico.picsum.ui.foundation.SetupCoil

@Composable
fun PicsumContainer(galleryDataSource: GalleryDataSource) {
    MaterialTheme {
        SetupCoil()
        val backStack = rememberNavBackStack(
            configuration = SavedStateConfiguration {
                serializersModule += SerializersModule {
                    polymorphic(NavKey::class) { subclass(GalleryRoute::class) }
                }
            },
            GalleryRoute,
        )
        NavDisplay(
            backStack = backStack,
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
                rememberGalleryDataSourceNavEntryDecorator(galleryDataSource = galleryDataSource),
            ),
            entryProvider = entryProvider {
                addGalleryRoute()
            }
        )
    }
}
