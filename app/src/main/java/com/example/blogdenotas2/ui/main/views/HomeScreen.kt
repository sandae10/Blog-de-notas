package com.example.blogdenotas2.ui.main.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.blogdenotas2.domain.notes.model.Note
import com.example.blogdenotas2.ui.components.NoteList
import com.example.blogdenotas2.ui.main.interaction.NoteState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigate: (MainDestinations) -> Unit,
    noteState: NoteState,
    onSelectedNote: (Note) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Add") },
                onClick = {
                    onNavigate(MainDestinations.AddScreen)
                },
                icon = {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "Add"
                    )
                }
            )
        }
    ) {
        NoteList(
            modifier = Modifier.padding(it),
            notes = noteState.notes,
            onSelectedNote = onSelectedNote
        )
    }
}

