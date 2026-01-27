package com.example.stepzzleaderboard.feature_profile.presentation.personal_steps

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stepzzleaderboard.feature_profile.domain.use_case.GetUsername
import com.example.stepzzleaderboard.feature_profile.domain.use_case.PreferencesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import javax.inject.Inject

@HiltViewModel
class PersonalStepsViewModel @Inject constructor(
    private val preferencesUseCases: PreferencesUseCases,
    saveStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(PersonalStepsState())
    val state: State<PersonalStepsState> = _state

    private var getPreferencesJob: Job? = null

    init {
        getUserName()
    }

    private fun getUserName() {
        preferencesUseCases.getUsername.invoke()
    }

}