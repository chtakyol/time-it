package com.tools_company.time_it.presentation.add_event_screen.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun GuidanceText(
    text: String = "Guidance Text"
) {
    val textColor = Color(0xFF484F57)
    Text(
        text = text,
        style = TextStyle(
            fontSize = 24.sp,
            color = textColor
        ),
        textAlign = TextAlign.Center
    )
}

@Composable
@Preview
fun PreviewGuidanceText() {
    GuidanceText()
}