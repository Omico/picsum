package me.omico.picsum.feature.gallery

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavEntryDecorator
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable
import me.omico.picsum.data.datasource.GalleryDataSource

@Serializable
data object GalleryRoute : NavKey

expect fun EntryProviderScope<NavKey>.addGalleryRoute()

@Composable
fun <T : Any> rememberGalleryDataSourceNavEntryDecorator(
    galleryDataSource: GalleryDataSource,
): GalleryDataSourceNavEntryDecorator<T> =
    remember(galleryDataSource) { GalleryDataSourceNavEntryDecorator(galleryDataSource) }

class GalleryDataSourceNavEntryDecorator<T : Any>(
    val galleryDataSource: GalleryDataSource,
) : NavEntryDecorator<T>(
    decorate = { entry ->
        CompositionLocalProvider(LocalGalleryDataSource provides galleryDataSource) {
            entry.Content()
        }
    }
)

val LocalGalleryDataSource: ProvidableCompositionLocal<GalleryDataSource> =
    compositionLocalOf { error("No GalleryDataSource provided") }
