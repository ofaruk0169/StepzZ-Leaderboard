package com.example.stepzzleaderboard.feature_steps.data.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

//This will define the field that our Step table should have
@Entity()
data class StepEntry(
    val dailyStepCounter: Int,
    val stepDate: String = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date()),
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
