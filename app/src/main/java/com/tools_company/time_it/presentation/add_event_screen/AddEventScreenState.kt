package com.tools_company.time_it.presentation.add_event_screen

import java.util.*

data class AddEventScreenState(
    val title: String = "",
    val shouldRemind: Boolean = false,
    val eventDate: Date = Date(),
    val content: String = "",
    val isDeleteButtonActive: Boolean = false
)
