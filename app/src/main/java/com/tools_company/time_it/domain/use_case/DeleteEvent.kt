package com.tools_company.time_it.domain.use_case

import com.tools_company.time_it.domain.IEventRepository
import com.tools_company.time_it.domain.model.Event

class DeleteEvent(
    private val repository: IEventRepository
) {

    suspend operator fun invoke(event: Event) {
        repository.deleteEvent(event)
    }
}