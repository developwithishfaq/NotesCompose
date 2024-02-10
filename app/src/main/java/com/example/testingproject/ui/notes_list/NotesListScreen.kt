package com.example.testingproject.ui.notes_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.testingproject.R
import com.example.testingproject.ui.base.LocalNavHostController
import com.example.testingproject.ui.components.HeadingText
import com.example.testingproject.ui.components.Routes
import com.example.testingproject.ui.components.VerticalSpacer
import com.example.testingproject.ui.notes_list.components.FabButton
import com.example.testingproject.ui.notes_list.components.NoteItem
import ir.kaaveh.sdpcompose.sdp
import org.koin.androidx.compose.koinViewModel

@Preview(showSystemUi = true)
@Composable
fun NotesListScreen(viewModel: NotesListViewModel = koinViewModel()) {
    val navController = LocalNavHostController.current
    val state by viewModel.state.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FabButton {
                navController.navigate(Routes.AddNotesScreen.name)
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = colorResource(id = R.color.bgColor)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VerticalSpacer(dp = 10.sdp)
            HeadingText(text = "Notes")
            VerticalSpacer(dp = 10.sdp)

            LazyColumn {
                items(state) { note ->
                    NoteItem(note, onClick = {
                        navController.navigate(
                            Routes.AddNotesScreen.name + "/${note.id}"
                        )
                    })
                }
            }

        }

    }

}