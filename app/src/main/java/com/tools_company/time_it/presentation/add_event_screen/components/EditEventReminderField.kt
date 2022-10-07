package com.tools_company.time_it.presentation.add_event_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tools_company.time_it.R

@Composable
fun EditEventReminderField(
    onRemindOnClicked: () -> Unit,
    onRemindOffClicked: () -> Unit
) {
    val reminderState = remember {
        mutableStateOf(false)
    }

    val activeColor = Color(0xFF8CBBF1)
    val passiveColor = Color(0xFFFDFDFF)
    Row(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Box(
            modifier = Modifier
                .clickable {
                    onRemindOnClicked()
                    reminderState.value = true
                }
                .background(
                    if (reminderState.value) activeColor else passiveColor
                )
                .fillMaxWidth(.5f),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_baseline_notifications_active_24),
                tint = Color(0xFF484F57),
                modifier = Modifier.size(32.dp),
                contentDescription = "Icon"
            )
        }
        Box(
            modifier = Modifier
                .clickable {
                    onRemindOffClicked()
                    reminderState.value = false
                }
                .background(
                    if (reminderState.value) passiveColor else activeColor
                )
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_baseline_notifications_off_24),
                tint = Color(0xFF484F57),
                modifier = Modifier.size(32.dp),
                contentDescription = "Icon"
            )
        }
    }
}

@Composable
@Preview
fun PreviewEditEventReminderField() {
    EditEventReminderField(onRemindOnClicked = {}) {
        
    }
}