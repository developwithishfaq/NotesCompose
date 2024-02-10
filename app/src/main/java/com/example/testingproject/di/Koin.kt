package com.example.testingproject.di

import androidx.room.Room
import com.example.testingproject.data.data_source.AppDatabase
import com.example.testingproject.data.data_source.NotesTableDao
import com.example.testingproject.data.repository.NotesRepositoryImpl
import com.example.testingproject.domain.repository.NotesRepository
import com.example.testingproject.domain.usecases.AddNoteUseCase
import com.example.testingproject.domain.usecases.GetNoteById
import com.example.testingproject.domain.usecases.GetNotesUseCase
import com.example.testingproject.ui.add_note.AddNotesViewModel
import com.example.testingproject.ui.notes_list.NotesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val sharedModules = module {

    single<AppDatabase> {
        Room.databaseBuilder(get(), AppDatabase::class.java, "AppDb")
            .build()
    }
    factory<NotesTableDao> {
        get<AppDatabase>().getMyDao()
    }
    viewModel {
        AddNotesViewModel(get(), get(), get())
    }
    factory {
        AddNoteUseCase(get())
    }
    factory<NotesRepository> {
        NotesRepositoryImpl(get())
    }
    viewModel {
        NotesListViewModel(get())
    }
    factory {
        GetNotesUseCase(get())
    }
    factory {
        GetNoteById(get())
    }

}