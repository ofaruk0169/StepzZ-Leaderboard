package com.example.stepzzleaderboard.feature_steps.domain.use_case

import com.example.stepzzleaderboard.feature_steps.domain.model.StepEntry
import com.example.stepzzleaderboard.feature_steps.domain.repository.StepEntryRepository

class UpdateDailyStep (
    private val repository: StepEntryRepository
) {
    suspend operator fun invoke(step: StepEntry) {
        repository.upsertStep(step)
    }
}