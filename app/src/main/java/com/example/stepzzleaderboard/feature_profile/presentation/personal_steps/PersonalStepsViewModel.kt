package com.example.stepzzleaderboard.feature_profile.presentation.personal_steps

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.stepzzleaderboard.feature_steps.domain.use_case.StepUseCases
import com.example.stepzzleaderboard.feature_steps.domain.util.StepOrder
import com.example.stepzzleaderboard.feature_steps.presentation.leaderboard.LeaderboardState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class PersonalStepsViewModel @Inject constructor(
    private val stepUseCases: StepUseCases,
    saveStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(PersonalStepsState())
    val state: State<PersonalStepsState> = _state

}