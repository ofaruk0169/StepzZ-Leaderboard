package com.example.stepzzleaderboard.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.example.stepzzleaderboard.feature_steps.data.data_source.StepZDatabase
import com.example.stepzzleaderboard.feature_steps.data.repository.StepEntryRepositoryImpl
import com.example.stepzzleaderboard.feature_steps.domain.repository.StepEntryRepository
import com.example.stepzzleaderboard.feature_steps.domain.use_case.GetDailyStep
import com.example.stepzzleaderboard.feature_steps.domain.use_case.GetStepHistory
import com.example.stepzzleaderboard.feature_steps.domain.use_case.StepUseCases
import com.example.stepzzleaderboard.feature_steps.domain.use_case.UpdateDailyStep
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import androidx.datastore.preferences.core.Preferences
import com.example.stepzzleaderboard.feature_profile.data.repository.UserPreferencesRepositoryImpl
import com.example.stepzzleaderboard.feature_profile.domain.repository.UserPreferencesRepository
import com.example.stepzzleaderboard.feature_profile.domain.use_case.GetUsername
import com.example.stepzzleaderboard.feature_profile.domain.use_case.SetUsername
import com.example.stepzzleaderboard.feature_profile.domain.use_case.UserPreferencesUseCases

private val Context.dataStore by preferencesDataStore(name = "user_preferences")

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideStepDatabase(app: Application): StepZDatabase {
        return Room.databaseBuilder(
            app,
            StepZDatabase::class.java,
            StepZDatabase.DATABASE_NAME
        ).build()
    }
    @Provides
    @Singleton
    fun provideStepRepository(db: StepZDatabase): StepEntryRepository {
        return StepEntryRepositoryImpl(db.dao)
    }
    @Provides
    @Singleton
    fun provideStepUseCases(repository: StepEntryRepository): StepUseCases {
        return StepUseCases(
            getDailyStep = GetDailyStep(repository),
            getStepHistory = GetStepHistory(repository),
            updateDailyStep = UpdateDailyStep(repository)
        )
    }

    @Provides
    @Singleton
    fun provideDataStore(app: Application): DataStore<Preferences> {
        return app.dataStore
    }

    @Provides
    @Singleton
    fun provideUserPreferencesRepository (dataStore: DataStore<Preferences>): UserPreferencesRepository {
        return UserPreferencesRepositoryImpl(dataStore)
    }

    @Provides
    @Singleton
    fun provideUserPreferencesRepositoryUseCases(repository: UserPreferencesRepository): UserPreferencesUseCases {
        return UserPreferencesUseCases(
            getUsername = GetUsername(repository),
            setUsername = SetUsername(repository)
        )
    }
}