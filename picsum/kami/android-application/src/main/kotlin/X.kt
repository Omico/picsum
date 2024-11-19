/*
 * Copyright 2024-2025 Omico. All Rights Reserved.
 */
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class X(val x: Int, val y: Int)

fun main() {
    val x = X(1, 2)
    println(x)
    Json.encodeToString(x).let(::println)
}
