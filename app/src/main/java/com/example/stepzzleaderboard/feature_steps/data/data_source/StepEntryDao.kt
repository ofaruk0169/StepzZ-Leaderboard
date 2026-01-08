package com.example.stepzzleaderboard.feature_steps.data.data_source

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.stepzzleaderboard.feature_steps.domain.model.StepEntry
import kotlinx.coroutines.flow.Flow

@Dao
interface StepEntryDao {

    @Upsert
    suspend fun upsertStep(steps: StepEntry)

    @Query("SELECT * FROM StepEntry WHERE id = :id")
    suspend fun getMostRecentStep(id: Int): StepEntry?

    @Query("SELECT * FROM StepEntry ORDER BY stepDate DESC")
    fun getStepsHistory(): Flow<List<StepEntry>>

}