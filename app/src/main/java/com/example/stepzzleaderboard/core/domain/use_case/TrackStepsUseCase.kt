package com.example.stepzzleaderboard.core.domain.use_case

import com.example.stepzzleaderboard.core.domain.model.StepsEntity
import com.example.stepzzleaderboard.core.domain.repository.StepRepository

//this will record how many steps were walked on a day.

class TrackStepsUseCase(
    private val stepRepository: StepRepository
) {
    suspend operator fun invoke(userId: Int, stepCount: Int): Result<StepsEntity> {
        return stepRepository.recordSteps(userId, stepCount)
    }
}