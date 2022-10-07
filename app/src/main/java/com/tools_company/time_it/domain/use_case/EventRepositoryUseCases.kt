package com.tools_company.time_it.domain.use_case

data class EventRepositoryUseCases(
    val getEvents: GetEvents,
    val addEvent: AddEvent,
    val deleteEvent: DeleteEvent,
    val getEventById: GetEventById
)
