/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
@file:Suppress("UnusedReceiverParameter")

import me.omico.gradm.dependency.Androidx
import me.omico.gradm.dependency.Coil
import me.omico.gradm.dependency.Delusion
import me.omico.gradm.dependency.Hilt
import me.omico.gradm.dependency.Kotlinx
import me.omico.gradm.dependency.Ktor
import me.omico.gradm.dependency.Okio
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

inline val KotlinDependencyHandler.androidx: Androidx get() = Androidx
inline val KotlinDependencyHandler.coil: Coil get() = Coil
inline val KotlinDependencyHandler.delusion: Delusion get() = Delusion
inline val KotlinDependencyHandler.hilt: Hilt get() = Hilt
inline val KotlinDependencyHandler.kotlinx: Kotlinx get() = Kotlinx
inline val KotlinDependencyHandler.ktor: Ktor get() = Ktor
inline val KotlinDependencyHandler.okio: Okio get() = Okio
