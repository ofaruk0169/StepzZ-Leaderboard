package com.example.stepzzleaderboard.feature_steps.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}