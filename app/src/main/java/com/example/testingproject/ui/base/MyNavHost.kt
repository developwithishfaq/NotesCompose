package com.example.testingproject.ui.base

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testingproject.ui.add_note.AddNoteUi
import com.example.testingproject.ui.components.Routes
import com.example.testingproject.ui.notes_list.NotesListScreen

@Composable
fun MyNavHost() {
    val controller = LocalNavHostController.current
    NavHost(navController = controller, startDestination = Routes.NotesListScreen.name) {

        composable(Routes.NotesListScreen.name) {
            NotesListScreen()
        }
        composable(Routes.AddNotesScreen.name+"/{id}") {
            AddNoteUi()
        }

    }
}