package com.example.stepzzleaderboard.core.domain.repository

import com.example.stepzzleaderboard.core.domain.model.StepsEntity

interface StepRepository {
        suspend fun recordSteps(userId: Int, stepCount: Int): Result<StepsEntity>
        suspend fun getStepsForUser(userId: Int): Result<List<StepsEntity>>
        suspend fun getStepsForUserInDateRange(userId: Int, startDate: Long, endDate: Long): Result<List<StepsEntity>>
        suspend fun getTotalStepsForDate(userId: Int, date: Long): Result<Int>
}