package com.example.stepzzleaderboard.feature_steps.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.stepzzleaderboard.feature_steps.data.domain.model.StepEntry

@Database(
    entities = [StepEntry::class],
    version = 1
)

abstract class StepZDatabase: RoomDatabase() {

    abstract val dao: StepEntryDao


    companion object {
        const val DATABASE_NAME = "stepz_db"
    }
}