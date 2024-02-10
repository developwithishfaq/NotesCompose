package com.example.testingproject.domain.repository

import com.example.testingproject.data.model.NotesTable
import kotlinx.coroutines.flow.Flow

interface NotesRepository {

    suspend fun insertOrUpdate(notesTable: NotesTable)
    suspend fun deleteNote(id: String)
    fun getAllNotes(): Flow<List<NotesTable>>

    suspend fun getNoteById(id: String): NotesTable?

}