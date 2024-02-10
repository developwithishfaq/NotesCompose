package com.example.testingproject.domain.usecases

import com.example.testingproject.data.model.toNotesData
import com.example.testingproject.domain.repository.NotesRepository
import com.example.testingproject.ui.notes_list.components.NotesData

class GetNoteById(
    private val repository: NotesRepository
) {

    suspend operator fun invoke(id: String): NotesData? {
        return repository.getNoteById(id)?.toNotesData()
    }
}