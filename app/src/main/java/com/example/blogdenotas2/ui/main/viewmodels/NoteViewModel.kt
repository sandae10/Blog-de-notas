package com.example.blogdenotas2.ui.main.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blogdenotas2.domain.notes.casosdeuso.CreateNotes
import com.example.blogdenotas2.domain.notes.casosdeuso.DeleteNote
import com.example.blogdenotas2.domain.notes.casosdeuso.ReadNotes
import com.example.blogdenotas2.domain.notes.casosdeuso.UpdateNote
import com.example.blogdenotas2.domain.notes.model.Note
import com.example.blogdenotas2.notes.NotesRepository
import com.example.blogdenotas2.ui.main.interaction.NoteEvent
import com.example.blogdenotas2.ui.main.interaction.NoteState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel

class NoteViewModel @Inject constructor(

    private val createNotes : CreateNotes,
    private val readNotes : ReadNotes,
    private val updateNote: UpdateNote,
    private val deleteNote: DeleteNote

) : ViewModel() {

    private val _state: MutableState<NoteState> = mutableStateOf(NoteState())
    val state: State<NoteState> get() = _state

    init {
        collectNotes()
    }

    fun onEvent(noteEvent: NoteEvent) {
        when(noteEvent){
            is NoteEvent.AddNote -> {
                onInsertNote(note = noteEvent.note)
            }

            NoteEvent.NavToHome -> {
                setNavToHome()
            }
            NoteEvent.NotNavToHome -> {
                unSetNavToHome()
            }

            is NoteEvent.DeleteNote -> {
                onDeleteNote(note = noteEvent.note)
            }
            is NoteEvent.SelectNote -> {
                onSelectNote(note = noteEvent.note)
            }
            is NoteEvent.UpdateNote -> {
                onUpdateNote(note = noteEvent.note)
            }
        }
    }

    private fun collectNotes() {
        viewModelScope.launch ( Dispatchers.IO ){
            val fetchedNotes = createNotes()
            //tenemos que hacer esta llamada debido a que el hilo principal no se daria
            //cuenta y no lo actualizaria
            Log.d("NOTES", fetchedNotes.toString())
            withContext(Dispatchers.Main){
                _state.value = _state.value.copy(notes = fetchedNotes)
            }
        }
    }

    private fun onInsertNote(note : Note) {
        viewModelScope.launch(Dispatchers.IO) {
            readNotes(note = note)
            collectNotes()
            setNavToHome()
        }
    }

    private fun onDeleteNote(note : Note) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteNote(note = note)
            collectNotes()
            setNavToHome()
        }
    }

    private fun onUpdateNote(note : Note) {
        viewModelScope.launch(Dispatchers.IO) {
            updateNote(note = note)
            collectNotes()
            setNavToHome()
        }
    }

    private fun onSelectNote(note: Note){
        _state.value = _state.value.copy(navToHome = true)
    }

    private fun setNavToHome() {
        _state.value = _state.value.copy(navToHome = true)
    }

    private fun unSetNavToHome() {
        _state.value = _state.value.copy(navToHome = false)
    }
}