/*
 * Copyright 2024 Omico. All Rights Reserved.
 */
package me.omico.picsum.data.database

import androidx.room.RoomDatabaseConstructor

expect object PicsumDatabaseConstructor : RoomDatabaseConstructor<PicsumDatabase> {
    override fun initialize(): PicsumDatabase
}
