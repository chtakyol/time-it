package com.tools_company.time_it.presentation.add_event_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tools_company.time_it.domain.model.Event
import com.tools_company.time_it.domain.model.InvalidEventException
import com.tools_company.time_it.domain.use_case.EventRepositoryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddEventScreenViewModel @Inject constructor(
    private val eventRepositoryUseCases: EventRepositoryUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private var _uiState = mutableStateOf(AddEventScreenState())
    val uiState: State<AddEventScreenState> = _uiState

    private var currentEventId: Int? = null

    init {
        savedStateHandle.get<Int>("eventId")?.let { eventId ->
            if (eventId != -1) {
                _uiState.value = uiState.value.copy(
                    isDeleteButtonActive = true
                )
                viewModelScope.launch {
                    eventRepositoryUseCases.getEventById(eventId)?.also { event ->
                        currentEventId = event.id
                        _uiState.value = uiState.value.copy(
                            title = event.title,
                            eventDate = event.date,
                            shouldRemind = event.shouldRemind,
                            content = event.content
                        )
                    }
                }
            }
        }

        val calendar = Calendar.getInstance()
        updateCustomDatePickerState(calendar)
    }

    fun onEvent(event: AddEventScreenEvent) {
        when (event) {
            is AddEventScreenEvent.TitleChanged -> {
                _uiState.value = _uiState.value.copy(
                    title = event.value
                )
            }
            is AddEventScreenEvent.DescriptionChanged -> {
                _uiState.value = _uiState.value.copy(
                    content = event.value
                )
            }
            AddEventScreenEvent.ConfirmPressed -> {
                viewModelScope.launch {
                    saveEvent()
                }
            }
            is AddEventScreenEvent.ReminderStateChanged -> {
                _uiState.value = _uiState.value.copy(
                    shouldRemind = event.value
                )
            }
            AddEventScreenEvent.DeletePressed -> {
                viewModelScope.launch {
                    currentEventId?.let {
                        eventRepositoryUseCases.getEventById(it)?.let {
                            eventRepositoryUseCases.deleteEvent(
                                it
                            )
                        }
                    }
                }
            }

        }
    }

    private suspend fun saveEvent() {
        try {
            eventRepositoryUseCases.addEvent(
                Event(
                    uiState.value.title,
                    uiState.value.shouldRemind,
                    uiState.value.eventDate,
                    uiState.value.content
                )
            )
        } catch (e: InvalidEventException){

        }
    }

    fun updateCustomDatePickerState(
        calendar: Calendar
    ) {
            _uiState.value = _uiState.value.copy(
                eventDate = Date(calendar.time.time
            )
        )
    }
}