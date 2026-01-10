package com.example.stepzzleaderboard.di

import android.app.Application
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


}