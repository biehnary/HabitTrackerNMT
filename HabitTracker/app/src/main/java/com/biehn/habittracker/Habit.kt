package com.biehn.habittracker

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalTime

@Entity(tableName = "habits")
data class Habit(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    var title: String,
    var description: String,
    val startDate: LocalDate,
    var endDate: LocalDate?,
    var failCount: Int = 0,
    var successCount: Int = 0,
    var priority: Int,
    var displayOrder: Int,
    var isCompletedToday: Boolean = false,
    var repetitionDays: Int,
    var isAlarmOn: Boolean = false,
    var alarmTime: LocalTime = LocalTime.of(9, 0),
    var isPaused: Boolean = false
)
