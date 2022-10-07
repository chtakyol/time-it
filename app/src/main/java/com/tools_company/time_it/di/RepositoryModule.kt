package com.tools_company.time_it.di

import android.app.Application
import androidx.room.Room
import com.tools_company.time_it.data.EventRepositoryImpl
import com.tools_company.time_it.data.local.EventDatabase
import com.tools_company.time_it.domain.IEventRepository
import com.tools_company.time_it.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideEventDatabase(app: Application): EventDatabase {
        return Room.databaseBuilder(
            app,
            EventDatabase::class.java,
            EventDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideEventRepository(db: EventDatabase): IEventRepository {
        return EventRepositoryImpl(db.eventDao)
    }

    @Provides
    @Singleton
    fun provideEventRepositoryUseCases(repository: IEventRepository): EventRepositoryUseCases {
        return EventRepositoryUseCases(
            addEvent = AddEvent(repository),
            deleteEvent = DeleteEvent(repository),
            getEventById = GetEventById(repository),
            getEvents = GetEvents(repository)
        )
    }
}