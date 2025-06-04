package com.example.stepzzleaderboard.core.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "friendships",
    primaryKeys = ["userId", "friendId"],
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["userId"],
            childColumns = ["friendId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class FriendshipEntity(
    val userId: Int,
    val friendId: Int,
    val createdAt: Long = System.currentTimeMillis()
) {

}