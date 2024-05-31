/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.api

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

internal actual val KtorHttpClientEngine: HttpClientEngine = Darwin.create()
