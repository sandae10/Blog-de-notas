package com.example.blogdenotas2.notes.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.blogdenotas2.notes.model.NoteEntity
import com.example.blogdenotas2.ui.theme.utils.Constants

@Dao

interface NoteDao {
    @Query("SELECT * FROM ${Constants.note_table_name}")
    fun getCreate(): List<NoteEntity>

    @Insert
    fun readAll(noteEntity: NoteEntity)

    @Delete
    fun delete( noteEntity: NoteEntity)

    @Update
    fun update( noteEntity: NoteEntity)
}