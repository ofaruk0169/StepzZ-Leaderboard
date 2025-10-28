package com.example.stepzzleaderboard.feature_steps.data.domain.repository

import com.example.stepzzleaderboard.feature_steps.data.domain.model.StepEntry
import kotlinx.coroutines.flow.Flow


interface StepEntryRepository {

    suspend fun upsertStep(step: StepEntry)

    suspend fun getOldestSteps(): Flow<List<StepEntry>>

    suspend fun getMostRecentSteps(): Flow<List<StepEntry>>
}