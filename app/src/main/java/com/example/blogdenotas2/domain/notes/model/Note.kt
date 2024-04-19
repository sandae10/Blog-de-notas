package com.example.blogdenotas2.domain.notes.model

import com.example.blogdenotas2.notes.model.NoteEntity

data class Note(
    val id: Int = 0 ,
    val title: String = "",
    val body: String = ""
)

//INVERSO
fun Note.toNoteEntity(): NoteEntity = NoteEntity(uid = id, title = title, body = body )

//NO INVERSO
fun NoteEntity.toNote(): Note = Note(id = uid, title = title, body = body)
