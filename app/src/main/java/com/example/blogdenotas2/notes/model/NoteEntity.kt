package com.example.blogdenotas2.notes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.blogdenotas2.ui.theme.utils.Constants

@Entity(tableName = Constants.note_table_name)
data class NoteEntity(
    @PrimaryKey (autoGenerate = true) val uid: Int,
    @ColumnInfo ( name = "title") val title: String,
    @ColumnInfo ( name = "body") val body: String
)
