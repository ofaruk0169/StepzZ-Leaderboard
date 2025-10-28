package com.example.stepzzleaderboard.feature_steps.data.data_source.repository

import com.example.stepzzleaderboard.feature_steps.data.data_source.StepEntryDao
import com.example.stepzzleaderboard.feature_steps.data.domain.model.StepEntry
import com.example.stepzzleaderboard.feature_steps.data.domain.repository.StepEntryRepository
import kotlinx.coroutines.flow.Flow

class StepEntryRepositoryImpl(
    private val dao: StepEntryDao
) : StepEntryRepository {
    override suspend fun upsertStep(step: StepEntry) {
        dao.upsertStep(step)
    }

    override suspend fun getOldestSteps(): Flow<List<StepEntry>> {
        return dao.getStepEntryByDate()
    }

    override suspend fun getMostRecentSteps(): Flow<List<StepEntry>> {
        return dao.getLatestStep()
    }
}



