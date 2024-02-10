package com.example.testingproject.ui.notes_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.testingproject.R
import ir.kaaveh.sdpcompose.sdp

@Composable
fun FabButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(50.sdp)
            .background(
                color = colorResource(id = R.color.cardColor), RoundedCornerShape(30)
            )
            .clickable {
                onClick.invoke()
            },

        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            modifier = Modifier.size(20.sdp)
        )
    }
}