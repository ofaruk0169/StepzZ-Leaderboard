package com.example.stepzzleaderboard.feature_steps.domain.util

sealed class StepOrder(val orderType: OrderType) {
    class Date(orderType: OrderType) : StepOrder(orderType)
    class StepCount(orderType: OrderType) : StepOrder(orderType)
}