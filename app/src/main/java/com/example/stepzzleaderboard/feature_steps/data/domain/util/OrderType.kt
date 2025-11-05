package com.example.stepzzleaderboard.feature_steps.data.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}