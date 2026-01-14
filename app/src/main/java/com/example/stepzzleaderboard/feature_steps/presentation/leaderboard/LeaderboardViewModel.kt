package com.example.stepzzleaderboard.feature_steps.presentation.leaderboard

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.stepzzleaderboard.feature_steps.domain.use_case.StepUseCases
import javax.inject.Inject


class LeaderboardViewModel @Inject constructor(
    private val stepUseCases: StepUseCases
) : ViewModel() {

    private val _state = mutableStateOf(LeaderboardState())
    val state: State<LeaderboardState> = _state


}