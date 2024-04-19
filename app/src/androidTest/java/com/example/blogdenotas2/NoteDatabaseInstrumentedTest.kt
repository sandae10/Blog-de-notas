package com.example.blogdenotas2

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.blogdenotas2.notes.local.NoteDao
import com.example.blogdenotas2.notes.local.NoteDatabase
import com.example.blogdenotas2.notes.model.NoteEntity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class NoteDatabaseInstrumentedTest {
    private lateinit var noteDao: NoteDao
    private lateinit var db: NoteDatabase

    @Before
    fun createDb(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, NoteDatabase::class.java).build()
        noteDao = db.noteDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb(){
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadAllNotes() {

        val noteEntity = NoteEntity(uid = 1, title = "Viaje", body = "Alistar comida")

        noteDao.readAll(noteEntity = noteEntity)

        val notes = noteDao.getCreate()

        noteDao.delete(noteEntity = noteEntity)

        println(notes)

    }
}