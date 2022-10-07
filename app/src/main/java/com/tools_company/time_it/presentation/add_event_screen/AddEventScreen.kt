package com.tools_company.time_it.presentation.add_event_screen

import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tools_company.time_it.presentation.add_event_screen.components.*
import com.tools_company.time_it.presentation.common_components.CustomButton
import com.tools_company.time_it.utils.Screen
import com.tools_company.time_it.utils.setAlarm
import com.tools_company.time_it.utils.toHumanReadableDate
import java.util.*

@Composable
fun AddEventScreen(
    viewModel: AddEventScreenViewModel = hiltViewModel(),
    navController: NavController = rememberNavController()
){
    val uiState = viewModel.uiState
    val backgroundColor = Color(0xFFFDFDFF)
    val context = LocalContext.current
    val localFocus = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        SmallTitle()

        EditEventInputField(
            label = "Title",
            value = uiState.value.title,
            onTextChanged = {
                viewModel.onEvent(AddEventScreenEvent.TitleChanged(it))
            },
            onNext = {
                localFocus.moveFocus(FocusDirection.Down)
            },
            onDone = {

            }
        )

        EditEventReminderField(
            onRemindOnClicked = {
                viewModel.onEvent(AddEventScreenEvent.ReminderStateChanged(true))
            },
            onRemindOffClicked = {
                viewModel.onEvent(AddEventScreenEvent.ReminderStateChanged(false))
            }
        )

        EditEventDateInputField(
            context = context,
            date = uiState.value.eventDate.time.toHumanReadableDate(),
            datePickerOnDateSetListener = {
                datePicker: DatePicker, year: Int, month: Int, dayOfMonth: Int -> ""
                val calendar = Calendar.getInstance()
                calendar.set(Calendar.YEAR, datePicker.year)
                calendar.set(Calendar.MONTH, datePicker.month)
                calendar.set(Calendar.DAY_OF_MONTH, datePicker.dayOfMonth)
                calendar.set(Calendar.HOUR_OF_DAY, 9) // TODO Get this from user
                viewModel.updateCustomDatePickerState(calendar)
            },
            onTextChanged = {
                uiState.value.eventDate.time.toHumanReadableDate()
            },
            onNext = {
                localFocus.moveFocus(FocusDirection.Down)
            },
            onDone = {

            }
        )

        EditEventInputField(
            label = "Description",
            value = uiState.value.content,
            onTextChanged = {
                viewModel.onEvent(AddEventScreenEvent.DescriptionChanged(it))
            },
            onNext = {
                localFocus.moveFocus(FocusDirection.Down)
            },
            onDone = {

            }
        )

        CustomButton(
            text = "Confirm"
        ) {
            viewModel.onEvent(AddEventScreenEvent.ConfirmPressed)
            navController.navigate(Screen.HomeScreen.route)
            if (uiState.value.shouldRemind) {
                context.setAlarm(uiState.value.eventDate)
            }
        }

        if (uiState.value.isDeleteButtonActive) {
            CustomButton(
                text = "Delete"
            ) {
                viewModel.onEvent(AddEventScreenEvent.DeletePressed)
                navController.navigate(Screen.HomeScreen.route)
                // TODO deactivate alarm
            }
        }
    }
}