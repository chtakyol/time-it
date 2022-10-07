package com.tools_company.time_it.presentation.add_event_screen.components

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
fun SmallTitle(

){
    val backgroundColor = Color(0xFF8CBBF1)
    val textColor = Color(0xFFFDFDFF)
    Box(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxWidth()
            .size(width = 360.dp, height = 76.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            modifier = Modifier
                .padding(start = 8.dp),
            text = "Add Event",
            style = TextStyle(
                color = textColor,
                fontSize = 36.sp
            )
        )
    }
}

@Composable
@Preview
fun PreviewSmallTitle() {
    SmallTitle()
}