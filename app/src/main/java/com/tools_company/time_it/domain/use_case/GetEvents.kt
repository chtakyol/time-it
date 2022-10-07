package com.tools_company.time_it.domain.use_case

import com.tools_company.time_it.domain.IEventRepository
import com.tools_company.time_it.domain.model.Event
import kotlinx.coroutines.flow.Flow

class GetEvents(
    private val repository: IEventRepository
) {

    operator fun invoke(): Flow<List<Event>> {
        return repository.getEvents()
    }
}