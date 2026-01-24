package com.example.stepzzleaderboard.feature_profile.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.stepzzleaderboard.feature_profile.domain.repository.UserPreferencesRepository
import kotlinx.coroutines.flow.first

class UserPreferencesRepositoryImpl(
    private val dataStore: DataStore<Preferences>
) : UserPreferencesRepository {
    val USERNAME_KEY = stringPreferencesKey("username")

    override suspend fun getUsername(): String {
        val preferences = dataStore.data.first()
        return preferences[USERNAME_KEY] ?: ""
    }

    override suspend fun setUsername(username: String) {
        dataStore.edit {
            it[USERNAME_KEY] = username
        }
    }

}