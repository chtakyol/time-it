package com.tools_company.time_it.presentation.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Title() {
    val backgroundColor = Color(0xFF8CBBF1)
    val textColor = Color(0xFFFDFDFF)
    Box(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxWidth()
            .size(width = 360.dp, height = 90.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            modifier = Modifier
                .padding(start = 8.dp),
            text = "Time It",
            style = TextStyle(
                color = textColor,
                fontSize = 48.sp
            )
        )
    }
}

@Composable
@Preview
fun PreviewTitle() {
    Title()
}