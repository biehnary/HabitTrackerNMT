package com.biehn.habittracker

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertHabit(habit: Habit)

    @Query("select * from habits")
    fun getAllHabits(): Flow<List<Habit>>

}