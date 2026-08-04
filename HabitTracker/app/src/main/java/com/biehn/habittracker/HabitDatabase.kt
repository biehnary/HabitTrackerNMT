package com.biehn.habittracker

import android.content.Context
import androidx.room.Room

object HabitDatabase {
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "habits-db"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}