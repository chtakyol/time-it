package com.tools_company.time_it.presentation.home_screen

import com.tools_company.time_it.domain.model.Event

data class HomeScreenState(
    val events: List<Event> = emptyList()
)
