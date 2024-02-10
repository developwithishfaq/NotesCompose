package com.example.testingproject.ui.add_note.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.testingproject.R
import ir.kaaveh.sdpcompose.sdp

@Composable
fun MyTextField(value: String, hint: String,modifier: Modifier = Modifier, onValueChange: ((String) -> Unit)? = null) {
    TextField(
        value = value, onValueChange = {
            onValueChange?.invoke(it)
        },
        modifier = modifier
            .fillMaxWidth()
            .border(
                1.dp,
                color = colorResource(id = R.color.almostBlack),
                RoundedCornerShape(10.sdp)
            )
            .padding(horizontal = 8.sdp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        placeholder = {
            Text(text = hint)
        }
    )
}