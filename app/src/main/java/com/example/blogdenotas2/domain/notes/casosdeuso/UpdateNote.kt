package com.example.blogdenotas2.domain.notes.casosdeuso

import com.example.blogdenotas2.domain.notes.model.Note
import com.example.blogdenotas2.domain.notes.model.toNoteEntity
import com.example.blogdenotas2.notes.NotesRepository
import javax.inject.Inject

class UpdateNote @Inject constructor(private val notesRepository: NotesRepository) {
    suspend operator fun invoke( note: Note) {
        notesRepository.updateNote( noteEntity = note.toNoteEntity())
    }
}