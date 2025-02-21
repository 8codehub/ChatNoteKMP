package com.plcoding.room_cmp.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.chatnote.coredata.db.AppDatabase

fun getAppDatabase(context: Context): AppDatabase {
    val dbFile = context.getDatabasePath("db.db")
    return Room.databaseBuilder<AppDatabase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}