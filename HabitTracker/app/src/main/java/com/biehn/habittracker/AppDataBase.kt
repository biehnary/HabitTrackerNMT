package com.biehn.habittracker

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Habit::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
}