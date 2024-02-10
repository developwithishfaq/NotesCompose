package com.example.testingproject.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testingproject.ui.notes_list.components.NotesData

@Entity("Notes")
data class NotesTable(
    val title: String,
    val message: String,
    val timeInMillis: Long,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)

fun NotesTable.toNotesData() = NotesData(
    id, title, message
)
