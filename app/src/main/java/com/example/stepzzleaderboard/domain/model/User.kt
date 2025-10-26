package com.example.stepzzleaderboard.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.stepzzleaderboard.ui.theme.*
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

//This will define the field that our Step table should have
@Entity()
data class StepEntry(
    val dailyStepCounter: Int,
    val currentDate: String = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date()),
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
