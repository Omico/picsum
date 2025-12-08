package me.omico.picsum.feature.gallery

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object GalleryRoute : NavKey

expect fun EntryProviderScope<NavKey>.addGalleryRoute()
