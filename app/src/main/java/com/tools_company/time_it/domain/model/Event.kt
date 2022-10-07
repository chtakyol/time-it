package com.tools_company.time_it.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Event(
    val title: String,
    val shouldRemind: Boolean,
    val date: Date,
    val content: String,
    @PrimaryKey val id: Int? = null
)

class InvalidEventException(message: String): Exception(message)
