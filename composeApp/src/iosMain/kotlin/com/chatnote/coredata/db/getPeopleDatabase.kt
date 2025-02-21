package com.chatnote.coredata.db

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.chatnote.coredata.*
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.*

@OptIn(ExperimentalForeignApi::class)
fun getDatabasePath(): String {
    val fileManager = NSFileManager.defaultManager
    val urls = NSSearchPathForDirectoriesInDomains(
        directory = NSApplicationSupportDirectory,
        domainMask = NSUserDomainMask,
        expandTilde = true
    )

    val databaseDir = urls.first() as String
    val dbFilePath = "$databaseDir/db.db"

    // Ensure the directory exists
    val directoryURL = NSURL.fileURLWithPath(databaseDir)
    val attributes = null // Default attributes

    if (!fileManager.fileExistsAtPath(databaseDir)) {
        fileManager.createDirectoryAtURL(
            directoryURL,
            withIntermediateDirectories = true,
            attributes = attributes,
            error = null
        )
    }

    return dbFilePath
}

fun getAppDatabase(): AppDatabase {
    return Room.databaseBuilder<AppDatabase>(
        name = getDatabasePath(),
        factory = { AppDatabase::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}
