package com.example.testingproject.data.data_source

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.testingproject.data.model.NotesTable
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesTableDao {

    @Upsert
    suspend fun insertNote(notesTable: NotesTable)

    @Query("DELETE FROM Notes WHERE id=:id")
    suspend fun deleteNote(id: String)


    @Query("SELECT * FROM Notes")
    fun getAllNotes(): Flow<List<NotesTable>>

    @Query("SELECT * FROM Notes WHERE id=:id")
    suspend fun getNoteById(id: String): NotesTable?


}