package com.example.stepzzleaderboard.feature_steps.presentation.personal_steps

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.stepzzleaderboard.feature_steps.domain.use_case.StepUseCases
import com.example.stepzzleaderboard.feature_steps.presentation.leaderboard.LeaderboardState
import javax.inject.Inject


class PersonalStepsViewModel @Inject constructor(
    private val stepUseCases: StepUseCases
) : ViewModel() {

    private val _state = mutableStateOf(PersonalStepsState())
    val state: State<PersonalStepsState> = _state


}