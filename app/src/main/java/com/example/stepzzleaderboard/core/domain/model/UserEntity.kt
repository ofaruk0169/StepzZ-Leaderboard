package com.example.stepzzleaderboard.core.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//we need a class that represents the relevent data for the Leaderboard, and that in the end is an entitiy which we need in the domain package
//

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val userId: Int,
    val userColor: Int,
    val userTextColor: Int,
    val userName: String,
    val profilePicture: String,
    val dailyStepzZ: Int,
    val friendRank: Int,
    val isFriend: Boolean,
    val isCurrentUser: Boolean
)

