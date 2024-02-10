package com.example.testingproject.ui.add_note

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.testingproject.R
import com.example.testingproject.ui.add_note.components.MyTextField
import com.example.testingproject.ui.base.LocalNavHostController
import com.example.testingproject.ui.components.HeadingText
import com.example.testingproject.ui.components.VerticalSpacer
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp
import org.koin.androidx.compose.koinViewModel

@Preview(showSystemUi = true)
@Composable
fun AddNoteUi(viewModel: AddNotesViewModel = koinViewModel()) {
    val context = LocalContext.current
    val navController = LocalNavHostController.current
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.sdp, vertical = 5.sdp)
                    .background(
                        colorResource(id = R.color.mainColor),
                        RoundedCornerShape(20)
                    )
                    .padding(horizontal = 8.sdp, vertical = 10.sdp)
                    .clickable {
                        viewModel.saveNote {
                            if (it.isBlank()) {
                                Toast
                                    .makeText(context, "Note Saved", Toast.LENGTH_SHORT)
                                    .show()
                                navController.popBackStack()
                            } else {
                                Toast
                                    .makeText(context, it, Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Save",
                    fontSize = 14.ssp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val state by viewModel.state.collectAsState()

            VerticalSpacer(dp = 10.sdp)
            HeadingText(text = "Add Note")
            VerticalSpacer(dp = 20.sdp)

            MyTextField(value = state.note.title,
                modifier = Modifier
                    .padding(horizontal = 8.sdp),
                hint = "title...", onValueChange = {
                    viewModel.setTitle(it)
                })
            VerticalSpacer(dp = 10.sdp)
            MyTextField(
                value = state.note.message,
                hint = "body...",
                modifier = Modifier
                    .height(100.sdp)
                    .padding(horizontal = 8.sdp),
                onValueChange = {
                    viewModel.setMessage(it)
                })
        }
    }
}