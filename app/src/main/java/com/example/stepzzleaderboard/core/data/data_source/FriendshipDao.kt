package com.example.stepzzleaderboard.core.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.stepzzleaderboard.core.domain.model.FriendshipEntity
import com.example.stepzzleaderboard.core.domain.model.UserEntity

@Dao
interface FriendshipDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun createFriendship(friendship: FriendshipEntity)

    @Query("SELECT * FROM friendships WHERE userId = :userId")
    suspend fun getFriendshipsForUser(userId: Int): List<FriendshipEntity>

    @Query("SELECT u.* FROM users u INNER JOIN friendships f ON u.userId = f.friendId WHERE f.userId = :userId")
    suspend fun getFriendsForUser(userId: Int): List<UserEntity>

    @Query("DELETE FROM friendships WHERE userId = :userId AND friendId = :friendId")
    suspend fun removeFriendship(userId: Int, friendId: Int)
}