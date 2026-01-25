package com.example.stepzzleaderboard.feature_profile.domain.use_case

import com.example.stepzzleaderboard.feature_steps.domain.use_case.GetDailyStep
import com.example.stepzzleaderboard.feature_steps.domain.use_case.GetStepHistory

data class UserPreferencesUseCases(
    val getUsername: GetUsername,
    val setUsername: SetUsername,
)