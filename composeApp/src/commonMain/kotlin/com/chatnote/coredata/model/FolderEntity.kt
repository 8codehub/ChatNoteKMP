package com.chatnote.coredata.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import currentTimeMillis

@Entity(tableName = "folders")
data class FolderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val name: String,
    val iconUri: String?,
    val createdAt: Long = currentTimeMillis(),
    val pinnedDate: Long = 0
)