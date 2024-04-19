package com.example.blogdenotas2.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.blogdenotas2.domain.notes.model.Note

@Composable
fun NoteCard(
    modifier: Modifier = Modifier,
    note: Note,
    onSelectedNote: (note: Note) -> Unit
) {
    Card(
        modifier = modifier.clickable { onSelectedNote(note) },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        )
    ){
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = note.title,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = note.body,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}