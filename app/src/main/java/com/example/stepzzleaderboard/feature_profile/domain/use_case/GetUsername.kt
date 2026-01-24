package com.example.stepzzleaderboard.feature_profile.domain.use_case

import com.example.stepzzleaderboard.feature_profile.domain.repository.UserPreferencesRepository
import com.example.stepzzleaderboard.feature_steps.domain.model.StepEntry
import com.example.stepzzleaderboard.feature_steps.domain.repository.StepEntryRepository

class GetUsername (
    private val repository: UserPreferencesRepository
){
    suspend operator fun invoke (): String {
        return repository.getUsername()
    }
}