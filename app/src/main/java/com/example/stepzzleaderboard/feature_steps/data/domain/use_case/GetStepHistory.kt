package com.example.stepzzleaderboard.feature_steps.data.domain.use_case

import androidx.room.Index
import com.example.stepzzleaderboard.feature_steps.data.domain.model.StepEntry
import com.example.stepzzleaderboard.feature_steps.data.domain.repository.StepEntryRepository
import com.example.stepzzleaderboard.feature_steps.data.domain.util.OrderType
import com.example.stepzzleaderboard.feature_steps.data.domain.util.StepOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetStepHistory (
    private val repository: StepEntryRepository
) {
    operator fun invoke(
        stepOrder: StepOrder = StepOrder.Date(OrderType.Descending)
    ): Flow<List<StepEntry>> {
        return repository.getStepsHistory().map { steps ->
            when(stepOrder.orderType) {
                is OrderType.Ascending -> {
                    when(stepOrder) {
                        is StepOrder.Date -> steps.sortedBy { it.stepDate }
                        is StepOrder.StepCount -> steps.sortedBy { it.dailyStepCounter }
                    }
                }
                is OrderType.Descending -> {
                    when(stepOrder) {
                        is StepOrder.Date -> steps.sortedByDescending { it.stepDate }
                        is StepOrder.StepCount -> steps.sortedByDescending { it.dailyStepCounter }
                    }
                }
            }
        }
    }
}