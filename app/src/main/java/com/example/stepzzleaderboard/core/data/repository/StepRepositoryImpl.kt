package com.example.stepzzleaderboard.core.data.repository

import com.example.stepzzleaderboard.core.data.data_source.StepsDao
import com.example.stepzzleaderboard.core.domain.model.StepsEntity
import com.example.stepzzleaderboard.core.domain.repository.StepRepository

class StepRepositoryImpl(
    private val stepsDao: StepsDao
) : StepRepository {

    override suspend fun recordSteps(userId: Int, stepCount: Int): Result<StepsEntity> {
        return try {
            val stepsEntity = StepsEntity(
                userId = userId,
                count = stepCount,
                date = System.currentTimeMillis()
            )
            stepsDao.recordSteps(stepsEntity)
            Result.success(stepsEntity)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getStepsForUser(userId: Int): Result<List<StepsEntity>> {
        return try {
            val steps = stepsDao.getStepsForUser(userId)
            Result.success(steps)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getStepsForUserInDateRange(userId: Int, startDate: Long, endDate: Long): Result<List<StepsEntity>> {
        return try {
            val steps = stepsDao.getStepsForUserInDateRange(userId, startDate, endDate)
            Result.success(steps)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getTotalStepsForDate(userId: Int, date: Long): Result<Int> {
        return try {
            val total = stepsDao.getTotalStepsForDate(userId, date) ?: 0
            Result.success(total)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}