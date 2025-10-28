package com.example.stepzzleaderboard.feature_steps.data.data_source

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.stepzzleaderboard.feature_steps.data.domain.model.StepEntry
import kotlinx.coroutines.flow.Flow

@Dao
interface StepEntryDao {

    @Upsert
    suspend fun upsertStep(steps: StepEntry)

    @Query("SELECT * FROM StepEntry ORDER BY currentDate DESC LIMIT 1")
    fun getLatestStep(): Flow<List<StepEntry>>

    @Query("SELECT * FROM StepEntry ORDER BY currentDate DESC")
    fun getStepEntryByDate(): Flow<List<StepEntry>>

}