package com.example.testingproject.data.repository

import com.example.testingproject.data.data_source.NotesTableDao
import com.example.testingproject.data.model.NotesTable
import com.example.testingproject.domain.repository.NotesRepository
import kotlinx.coroutines.flow.Flow

class NotesRepositoryImpl(
    private val notesTableDao: NotesTableDao
) : NotesRepository {
    override suspend fun insertOrUpdate(notesTable: NotesTable) {
        notesTableDao.insertNote(notesTable)
    }

    override suspend fun deleteNote(id: String) {
        notesTableDao.deleteNote(id)

    }

    override fun getAllNotes(): Flow<List<NotesTable>> = notesTableDao.getAllNotes()
    override suspend fun getNoteById(id: String): NotesTable? {
        return notesTableDao.getNoteById(id)
    }
}