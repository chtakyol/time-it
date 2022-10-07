package com.tools_company.time_it.domain.use_case

import com.tools_company.time_it.domain.IEventRepository
import com.tools_company.time_it.domain.model.Event

class GetEventById(
    private val repository: IEventRepository
) {

    suspend operator fun invoke(id: Int): Event? {
        return repository.getEventById(id)
    }
}