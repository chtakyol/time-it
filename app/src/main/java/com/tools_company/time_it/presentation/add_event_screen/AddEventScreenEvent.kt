package com.tools_company.time_it.presentation.add_event_screen

sealed class AddEventScreenEvent {
    data class TitleChanged(val value: String): AddEventScreenEvent()
    data class DescriptionChanged(val value: String): AddEventScreenEvent()
    data class ReminderStateChanged(val value: Boolean): AddEventScreenEvent()
    object ConfirmPressed: AddEventScreenEvent()
    object DeletePressed: AddEventScreenEvent()
}
