/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.api

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

internal actual val KtorHttpClientEngine: HttpClientEngine = OkHttp.create()
