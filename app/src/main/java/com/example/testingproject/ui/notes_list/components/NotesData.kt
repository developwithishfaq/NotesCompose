package com.example.testingproject.ui.notes_list.components

import com.example.testingproject.data.model.NotesTable

data class NotesData(
    val id: Int = 0,
    val title: String = "",
    val message: String = ""
)

fun NotesData.toNotesTable(): NotesTable {
    return NotesTable(
        title,
        message,
        System.currentTimeMillis(),
        id,
    )
}
