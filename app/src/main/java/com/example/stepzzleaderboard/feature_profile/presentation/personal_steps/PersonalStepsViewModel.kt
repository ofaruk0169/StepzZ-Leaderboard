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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonalStepsViewModel @Inject constructor(
    private val preferencesUseCases: PreferencesUseCases,
    saveStateHandle: SavedStateHandle
) : ViewModel() {

    private val _username = mutableStateOf(PersonalStepsState())
    val username: State<PersonalStepsState> = _username

    private var getPreferencesJob: Job? = null

    init {
        getUserName()
    }

    private fun getUserName() {
        viewModelScope.launch {
            val username = preferencesUseCases.getUsername()
            _username.value = _username.value.copy(username = username)
        }
    }
}