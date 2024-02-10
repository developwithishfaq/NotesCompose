package com.example.testingproject.ui.notes_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.testingproject.R
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Preview(showSystemUi = true)
@Composable
fun NoteItem(
    notesData: NotesData = NotesData(0, "Ishfaq", "Message here"),
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick?.invoke()
            }
            .padding(horizontal = 6.sdp, vertical = 4.sdp),
        shape = RoundedCornerShape(10),
        colors = CardDefaults.cardColors(
            colorResource(id = R.color.cardColor)
        ),
        elevation = CardDefaults.cardElevation(4.sdp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.sdp, vertical = 8.sdp),
            verticalArrangement = Arrangement.spacedBy(3.sdp)
        ) {
            Text(
                text = notesData.title,
                fontSize = 12.ssp,
                color = colorResource(id = R.color.black)
            )
            Text(
                text = notesData.message,
                fontSize = 10.ssp,
                color = colorResource(id = R.color.almostBlack)
            )
        }
    }
}