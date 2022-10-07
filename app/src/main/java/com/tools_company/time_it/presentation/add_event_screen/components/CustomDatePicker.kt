package com.tools_company.time_it.presentation.add_event_screen.components

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.*
import com.tools_company.time_it.R

@Composable
fun CustomDatePicker(
    context: Context,
    year: Int,
    month: Int,
    day: Int,
    date: String,
    datePickerOnDateSetListener: DatePickerDialog.OnDateSetListener,
    modifier: Modifier = Modifier,
) {
    val datePickerDialog = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        DatePickerDialog(
            context,
            datePickerOnDateSetListener,
            year,
            month,
            day
        )
    } else {
        TODO("VERSION.SDK_INT < N")
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {

        TextField(
            enabled = false,
            value = date,
            onValueChange = {
            },
            modifier = modifier
        )

        Row(
            modifier = modifier,
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
@Preview
fun PreviewCustomDatePicker() {
//    val context = LocalContext.current
//    CustomDatePicker(
//        context,
//        1,
//        2,
//        2022,
//        "01/02/2022"
//    )
}

@Composable
@Preview
fun PreviewDatePickerButton() {
    DatePickerButton()
}