package com.tools_company.time_it.data

import com.tools_company.time_it.data.local.EventDao
import com.tools_company.time_it.domain.model.Event
import com.tools_company.time_it.domain.IEventRepository
import kotlinx.coroutines.flow.Flow

class EventRepositoryImpl(
    private val dao: EventDao
): IEventRepository {
    override fun getEvents(): Flow<List<Event>> {
        return dao.getEvents()
    }

    override suspend fun getEventById(id: Int): Event? {
        return dao.getEventById(id)
    }

    override suspend fun insertEvent(event: Event) {
        dao.insertEvent(event)
    }

    override suspend fun deleteEvent(event: Event) {
        dao.deleteEvent(event)
    }
}