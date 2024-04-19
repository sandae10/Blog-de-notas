package com.example.blogdenotas2.ui.theme.utils

import com.example.blogdenotas2.domain.notes.model.Note

object Constants {
    const val note_database = "database_note"
    const val note_table_name = "note"

    val notes = listOf(
        Note(id = 0, title = "Viaje", body = "- No lo se xddx\n- Alistar la ropa" ),
        Note(id = 0, title = "Proyecto", body = "- Paradigmas\n- Alistar la ropa" ),
        Note(id = 0, title = "Equipo", body = "- Mochila\n- Alistar la ropa" ),
        Note(id = 0, title = "Wa", body = "- Wa\n- Alistar la ropa" ),

    )
}