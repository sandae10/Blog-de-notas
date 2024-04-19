package com.example.blogdenotas2.domain.notes.casosdeuso

import com.example.blogdenotas2.domain.notes.model.Note
import com.example.blogdenotas2.domain.notes.model.toNoteEntity
import com.example.blogdenotas2.notes.NotesRepository
import javax.inject.Inject

class ReadNotes @Inject constructor( private val notesRepository: NotesRepository) {
    suspend operator fun invoke( note: Note ) {
        notesRepository.readNote( noteEntity = note.toNoteEntity())
    }
}