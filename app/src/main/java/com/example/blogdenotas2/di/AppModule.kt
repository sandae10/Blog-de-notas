package com.example.blogdenotas2.di

import android.content.Context
import androidx.room.Room
import com.example.blogdenotas2.notes.NotesRepository
import com.example.blogdenotas2.notes.local.NoteDao
import com.example.blogdenotas2.notes.local.NoteDatabase
import com.example.blogdenotas2.ui.theme.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun providesNotesRoomDatabase(@ApplicationContext app: Context): NoteDatabase = Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            Constants.note_database
        ).build()

    @Provides
    @Singleton
    fun providesNatesDao(noteDatabase: NoteDatabase): NoteDao = noteDatabase.noteDao()



}