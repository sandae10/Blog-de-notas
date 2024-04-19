package com.example.blogdenotas2.ui.main.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.blogdenotas2.domain.notes.model.Note
import com.example.blogdenotas2.ui.main.interaction.NoteEvent
import com.example.blogdenotas2.ui.main.interaction.NoteState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateScreen(
    selectedNote: Note,
    onNavigate: (MainDestinations) -> Unit,
    noteState: NoteState,
    onEvent: (noteEvent: NoteEvent) -> Unit
) {
    var title by remember { mutableStateOf(selectedNote.title) }
    var body by remember { mutableStateOf(selectedNote.body) }
    if (noteState.navToHome) {
        onNavigate(MainDestinations.HomeScreen)
        onEvent(NoteEvent.NotNavToHome)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            TextField(
                modifier = Modifier.fillMaxSize(),
                value = title,
                onValueChange = { newText ->
                    title = newText },
                label = { Text("Title") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                modifier = Modifier.fillMaxSize(),
                value = body,
                onValueChange = { newText -> body = newText },
                label = { Text("Start typing") }
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    onEvent(NoteEvent.UpdateNote(
                        Note(
                            id = selectedNote.id,
                            title = title,
                            body = body)
                        )
                    )
                }) {
                    Icon(
                        Icons.Filled.Done,
                        contentDescription = "Done",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text(text = "Update")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                TextButton(onClick = {
                    onEvent(NoteEvent.DeleteNote(
                        Note(
                            id = selectedNote.id,
                            title = selectedNote.title,
                            body = selectedNote.body)
                        )
                    )
                }) {
                    Text("Delete")
                }
            }
        }
    }
}