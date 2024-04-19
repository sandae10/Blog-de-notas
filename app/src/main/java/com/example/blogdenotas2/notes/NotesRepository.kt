package com.example.blogdenotas2.notes

import com.example.blogdenotas2.notes.local.NoteDao
import com.example.blogdenotas2.notes.model.NoteEntity
import javax.inject.Inject

class NotesRepository @Inject constructor(
    private val noteDao: NoteDao
) {
    fun createAllNotes(): List<NoteEntity> {
        return noteDao.getCreate()
    }

    fun readNote(noteEntity: NoteEntity) = noteDao.readAll(noteEntity = noteEntity)

    fun updateNote(noteEntity: NoteEntity) = noteDao.update(noteEntity = noteEntity)

    fun deleteNote(noteEntity: NoteEntity) = noteDao.delete(noteEntity = noteEntity)

}