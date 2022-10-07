package com.tools_company.time_it.presentation.home_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tools_company.time_it.domain.model.Event
import com.tools_company.time_it.domain.use_case.EventRepositoryUseCases
import com.tools_company.time_it.presentation.add_event_screen.AddEventScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val eventRepositoryUseCases: EventRepositoryUseCases
): ViewModel() {

    private var _uiState = mutableStateOf(HomeScreenState())
    val uiState: State<HomeScreenState> = _uiState

    private var getEventsJob: Job? = null

    init {
        getEvents()
    }

    private fun getEvents() {
        getEventsJob?.cancel()
        getEventsJob = eventRepositoryUseCases.getEvents()
            .onEach { events ->
                _uiState.value = uiState.value.copy(
                    events = events
                )
            }
            .launchIn(viewModelScope)
    }

    private suspend fun deleteEvent(event: Event) {
        eventRepositoryUseCases.deleteEvent(event)
    }
}