package com.example.stepzzleaderboard.feature_steps.domain.use_case

import com.example.stepzzleaderboard.feature_steps.domain.model.StepEntry
import com.example.stepzzleaderboard.feature_steps.domain.repository.StepEntryRepository

class GetDailyStep(
    private val repository: StepEntryRepository
) {
    suspend operator fun invoke (id: Int): StepEntry? {
        return repository.getMostRecentStep(id)
    }
}