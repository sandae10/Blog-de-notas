package com.example.blogdenotas2.ui.main.interaction

import com.example.blogdenotas2.domain.notes.model.Note

//Esto construye la comunicacion de la screen con el viewmodel
sealed class NoteEvent{
    object NavToHome: NoteEvent()
    object NotNavToHome: NoteEvent()
    data class AddNote(val note : Note): NoteEvent()
    data class UpdateNote(val note : Note) : NoteEvent()
    data class DeleteNote(val note : Note) : NoteEvent()
    data class SelectNote(val note : Note) : NoteEvent()

}
