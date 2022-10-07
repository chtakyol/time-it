package com.tools_company.time_it.presentation.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
fun EventCard(
    modifier: Modifier = Modifier,
    title: String = "Title",
    date: String = "",
    content: String = "Content"
) {
    val cardBackgroundColor = Color(0xFFD7DDE9)
    val cardTextColor = Color(0xFF484F57)
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(width = 338.dp, height = 120.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(cardBackgroundColor)
    ) {
        Column(
            modifier = Modifier
                .size(width = 338.dp, height = 120.dp)
                .padding(start = 8.dp, top = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 24.sp,
                    color = cardTextColor
                )
            )

            Text(
                text = date,
                style = TextStyle(
                    fontSize = 24.sp,
                    color = cardTextColor
                )
            )

            Text(
                text = content,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = cardTextColor
                )
            )
        }
    }
}

@Composable
@Preview
fun PreviewEventCard() {
    EventCard()
}