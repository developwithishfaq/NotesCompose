package com.example.testingproject.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testingproject.data.model.NotesTable

@Database(entities = [NotesTable::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getMyDao(): NotesTableDao
}