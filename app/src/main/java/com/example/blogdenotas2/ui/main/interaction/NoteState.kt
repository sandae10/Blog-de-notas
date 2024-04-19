package com.example.blogdenotas2.ui.main.interaction

import com.example.blogdenotas2.domain.notes.model.Note

data class NoteState (
    var notes : List<Note> = emptyList(),
    var navToHome : Boolean = false,
    var selectedNote : Note = Note()
)