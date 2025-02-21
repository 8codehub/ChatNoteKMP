package com.chatnote.coredata.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chatnote.coredata.di.model.NoteEntity
import com.chatnote.coredata.model.FolderEntity

@Database(
    entities = [FolderEntity::class, NoteEntity::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun folderDao(): FolderDao
    abstract fun noteDao(): NoteDao
}
