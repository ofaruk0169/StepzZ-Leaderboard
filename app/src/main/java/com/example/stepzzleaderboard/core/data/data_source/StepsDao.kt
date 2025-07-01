package com.example.stepzzleaderboard.core.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.stepzzleaderboard.core.domain.model.StepsEntity

@Dao
interface StepsDao {

    @Insert
    suspend fun recordSteps(steps: StepsEntity)

    @Query("SELECT * FROM steps WHERE userId = :userId ORDER BY date DESC")
    suspend fun getStepsForUser(userId: Int): List<StepsEntity>

    @Query("SELECT * FROM steps WHERE userId = :userId AND date >= :startDate AND date <= :endDate")
    suspend fun getStepsForUserInDateRange(userId: Int, startDate: Long, endDate: Long): List<StepsEntity>

    @Query("SELECT SUM(count) FROM steps WHERE userId = :userId AND date = :date")
    suspend fun getTotalStepsForDate(userId: Int, date: Long): Int?

}