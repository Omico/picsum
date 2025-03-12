plugins {
    id("me.omico.dehell")
}

dehell {
    rules {
        match(
            name = "Jetpack",
            url = "https://developer.android.com/jetpack",
            by = group, type = prefix, value = "androidx.",
        )
        match(
            name = "Jetpack Compose",
            url = "https://developer.android.com/compose",
            by = group, type = prefix, value = "androidx.compose.",
        )
        match(
            name = "Jetpack Paging",
            url = "https://developer.android.com/topic/libraries/architecture/paging/v3-overview",
            by = group, type = exact, value = "androidx.paging",
        )
        match(
            name = "Kotlinx Coroutines",
            url = "https://kotlinlang.org/docs/coroutines-guide.html",
            by = module, type = prefix, value = "org.jetbrains.kotlinx:kotlinx-coroutines",
        )
        match(
            name = "Kotlinx Serialization",
            url = "https://kotlinlang.org/docs/serialization.html",
            by = module, type = prefix, value = "org.jetbrains.kotlinx:kotlinx-serialization",
        )
        match(
            name = "Compose Multiplatform",
            url = "https://www.jetbrains.com/compose-multiplatform",
            by = group, type = prefix, value = "org.jetbrains.compose.",
        )
        match(
            name = "Coil 3",
            url = "https://coil-kt.github.io/coil",
            by = group, type = exact, value = "io.coil-kt.coil3",
        )
        match(
            name = "Dagger",
            url = "https://dagger.dev",
            by = group, type = exact, value = "com.google.dagger",
        )
        match(
            name = "Hilt",
            url = "https://developer.android.com/training/dependency-injection/hilt-android",
            by = module, type = exact, value = "com.google.dagger:hilt-android",
        )
        match(
            name = "Ktor",
            url = "https://ktor.io",
            by = group, type = exact, value = "io.ktor",
        )
        match(
            name = "Kotlin",
            url = "https://kotlinlang.org",
            by = group, type = exact, value = "org.jetbrains.kotlin",
        )
        match(
            name = "JetBrains Annotations",
            url = "https://github.com/JetBrains/java-annotations",
            by = module, type = exact, value = "org.jetbrains:annotations",
        )
        match(
            name = "Okio",
            url = "https://square.github.io/okio",
            by = group, type = exact, value = "com.squareup.okio",
        )
        ignore(
            by = group, type = exact,
            "com.google.code.findbugs",
            "jakarta.inject",
            "javax.inject",
            "me.omico.delusion",
            "org.jspecify",
        )
    }
}
