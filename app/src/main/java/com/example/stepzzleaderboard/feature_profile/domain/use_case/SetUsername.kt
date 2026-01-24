package com.example.stepzzleaderboard.feature_profile.domain.use_case

import com.example.stepzzleaderboard.feature_profile.domain.repository.UserPreferencesRepository

class SetUsername(
    private val repository: UserPreferencesRepository
) {
    suspend operator fun invoke (userInput: String) {
        repository.setUsername(userInput)
    }
}