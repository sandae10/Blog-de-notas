package com.example.blogdenotas2.domain.notes.casosdeuso

import com.example.blogdenotas2.domain.notes.model.Note
import com.example.blogdenotas2.domain.notes.model.toNote
import com.example.blogdenotas2.notes.NotesRepository
import javax.inject.Inject

class CreateNotes @Inject constructor(private val notesRepository: NotesRepository){
    suspend operator fun invoke(): List<Note> {
        return notesRepository.createAllNotes().map {
            it.toNote()
        }
    }
}