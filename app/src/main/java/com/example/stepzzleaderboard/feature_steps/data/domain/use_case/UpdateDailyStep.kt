package com.example.stepzzleaderboard.feature_steps.data.domain.use_case

import com.example.stepzzleaderboard.feature_steps.data.domain.model.StepEntry
import com.example.stepzzleaderboard.feature_steps.data.domain.repository.StepEntryRepository

class UpdateDailyStep (
    private val repository: StepEntryRepository
) {
    suspend operator fun invoke(step: StepEntry) {
        repository.upsertStep(step)
    }
}