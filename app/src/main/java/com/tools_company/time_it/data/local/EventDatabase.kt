package com.tools_company.time_it.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.tools_company.time_it.domain.model.Event

@Database(
    entities = [Event::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class EventDatabase: RoomDatabase() {

    abstract val eventDao: EventDao

    companion object {
        const val DATABASE_NAME = "event_db"
    }
}