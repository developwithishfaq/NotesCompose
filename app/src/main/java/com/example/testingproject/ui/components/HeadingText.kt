package com.example.testingproject.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.example.testingproject.R
import ir.kaaveh.sdpcompose.ssp

@Composable
fun HeadingText(text: String) {
    Text(
        text = text,
        color = colorResource(id = R.color.black),
        fontWeight = FontWeight.Medium,
        fontSize = 13.ssp
    )
}