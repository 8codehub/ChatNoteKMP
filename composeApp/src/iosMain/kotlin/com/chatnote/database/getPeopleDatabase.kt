package database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
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
    val dbFilePath = "$databaseDir/people.db"

    // Ensure the directory exists
    val directoryURL = NSURL.fileURLWithPath(databaseDir)
    val attributes = null // Default attributes

    if (!fileManager.fileExistsAtPath(databaseDir)) {
        fileManager.createDirectoryAtURL(directoryURL, withIntermediateDirectories = true, attributes = attributes, error = null)
    }

    return dbFilePath
}

fun getPeopleDatabase(): PeopleDatabase {
    return Room.databaseBuilder<PeopleDatabase>(
        name = getDatabasePath(),
        factory = { PeopleDatabase::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}
