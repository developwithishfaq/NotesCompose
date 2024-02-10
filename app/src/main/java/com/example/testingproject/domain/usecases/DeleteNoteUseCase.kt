package com.example.testingproject.domain.usecases

import com.example.testingproject.domain.repository.NotesRepository

class DeleteNoteUseCase(
    private val repository: NotesRepository
) {

    suspend fun invoke(id: String) {
        repository.deleteNote(id)
    }
}