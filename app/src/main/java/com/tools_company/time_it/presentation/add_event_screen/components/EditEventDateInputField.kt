package com.tools_company.time_it.presentation.add_event_screen.components

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tools_company.time_it.R
import java.util.*

@Composable
fun EditEventDateInputField(
    context: Context,
    date: String = "",
    datePickerOnDateSetListener: DatePickerDialog.OnDateSetListener,
    onTextChanged: (String) -> Unit,
    onNext: (KeyboardActionScope) -> Unit,
    onDone: (KeyboardActionScope) -> Unit,
    onClick: () -> Unit = {}
) {

    val datePickerDialog = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        DatePickerDialog(
            context,
            datePickerOnDateSetListener,
            Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.MONTH),
            Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        )
    } else {
        TODO("VERSION.SDK_INT < N")
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clickable {
                onClick()
            }
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Start
        ) {
            EditEventInputField(
                label = "Date",
                onTextChanged = onTextChanged,
                isEnabled = false,
                value = date,
                onNext = onNext,
                onDone = onDone
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            DatePickerButton(
                onClick = {
                    datePickerDialog.show()
                }
            )
        }

    }

}

@Composable
fun DatePickerButton(
    onClick: () -> Unit = {}
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(64.dp))
            .size(width = 64.dp, height = 64.dp)
            .clickable {
                onClick()
            }
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_baseline_today_24),
            tint = Color(0xFF484F57),
            modifier = Modifier.size(32.dp),
            contentDescription = "Icon"
        )
    }
}

@Composable
@Preview
fun PreviewEditEventDateInputField() {
    EditEventDateInputField(
        context = LocalContext.current,
        datePickerOnDateSetListener = {
                datePicker: DatePicker, year: Int, month: Int, dayOfMonth: Int -> ""
        },
        onTextChanged = {

        },
        onNext = {

        },
        onDone = {

        }
    )
}