package com.tools_company.time_it.presentation.common_components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String = "Custom Button",
    onClick: () -> Unit = {}
) {
    val buttonBackgroundColor = Color(0xFF8CBBF1)
    val buttonTextColor = Color(0xFFFDFDFF)
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(width = 320.dp, height = 40.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(buttonBackgroundColor)
            .clickable {
                onClick()
            }
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                color = buttonTextColor
            )
        )
    }
}

@Composable
@Preview
fun PreviewCustomButton() {
    CustomButton()
}