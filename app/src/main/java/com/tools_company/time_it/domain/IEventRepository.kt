package com.tools_company.time_it.domain

import com.tools_company.time_it.domain.model.Event
import kotlinx.coroutines.flow.Flow

interface IEventRepository {
    fun getEvents(): Flow<List<Event>>

    suspend fun getEventById(id: Int): Event?

    suspend fun insertEvent(event: Event)

    suspend fun deleteEvent(event: Event)
}