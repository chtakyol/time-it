package com.tools_company.time_it.domain.use_case

import com.tools_company.time_it.domain.IEventRepository
import com.tools_company.time_it.domain.model.Event

class AddEvent(
    private val repository: IEventRepository
) {

    suspend operator fun invoke(event: Event) {
        if (event.title.isBlank()) {
            TODO("Throw error for empty title")
        }
        repository.insertEvent(event)
    }
}