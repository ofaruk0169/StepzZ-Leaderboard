package com.example.stepzzleaderboard.feature_profile.domain.repository

interface UserPreferencesRepository {

    suspend fun getUsername(): String

    suspend fun setUsername(username: String)

}