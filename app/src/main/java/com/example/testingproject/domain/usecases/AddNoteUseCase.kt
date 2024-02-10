package com.example.testingproject.domain.usecases

import com.example.testingproject.domain.repository.NotesRepository
import com.example.testingproject.ui.notes_list.components.NotesData
import com.example.testingproject.ui.notes_list.components.toNotesTable

class AddNoteUseCase(
    private val repository: NotesRepository
) {

    suspend operator fun invoke(notesData: NotesData) {
        repository.insertOrUpdate(notesData.toNotesTable())
    }
}