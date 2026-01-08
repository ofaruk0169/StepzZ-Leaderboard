package com.example.stepzzleaderboard.feature_steps.data.data_source.repository

import com.example.stepzzleaderboard.feature_steps.data.data_source.StepEntryDao
import com.example.stepzzleaderboard.feature_steps.domain.model.StepEntry
import com.example.stepzzleaderboard.feature_steps.domain.repository.StepEntryRepository
import kotlinx.coroutines.flow.Flow

class StepEntryRepositoryImpl(
    private val dao: StepEntryDao
) : StepEntryRepository {
    override suspend fun upsertStep(step: StepEntry) {
        dao.upsertStep(step)
    }

    override suspend fun getMostRecentStep(id: Int): StepEntry? {
        return dao.getMostRecentStep(id)
    }

    override fun getStepsHistory(): Flow<List<StepEntry>> {
        return dao.getStepsHistory()
    }
}



