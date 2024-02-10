package com.example.testingproject.domain.usecases

import com.example.testingproject.data.model.toNotesData
import com.example.testingproject.domain.repository.NotesRepository
import com.example.testingproject.ui.notes_list.components.NotesData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(
    private val repository: NotesRepository
) {

    operator fun invoke(): Flow<List<NotesData>> {
        return repository.getAllNotes().map { list ->
            list.map {
                it.toNotesData()
            }
        }
    }
}