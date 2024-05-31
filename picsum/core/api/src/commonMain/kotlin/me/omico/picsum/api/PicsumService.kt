/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json

class PicsumService {
    internal val httpClient: HttpClient = HttpClient(KtorHttpClientEngine) {
        install(ContentNegotiation) {
            json()
        }
        defaultRequest {
            url {
                host = HOST
            }
        }
    }

    companion object {
        private const val HOST = "picsum.photos"
    }
}

internal expect val KtorHttpClientEngine: HttpClientEngine
