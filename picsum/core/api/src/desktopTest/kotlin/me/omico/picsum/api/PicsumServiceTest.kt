/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.api

import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class PicsumServiceTest {
    @Test
    fun `test list images`() {
        runBlocking {
            assertEquals(
                expected = picsumServiceFirstTwoResults,
                actual = testPicsumService.list(page = 1, limit = 2),
            )
        }
    }
}
