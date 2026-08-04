package com.biehn.habittracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HabitViewModel(application: Application) : AndroidViewModel(application) {

    private val habitDao = HabitDatabase.getDatabase(application).habitDao()
    var habits: StateFlow<List<Habit>> = habitDao.getAllHabits()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    // 비즈니스 로직: 체크박스 토글
    fun toggleHabitCompletion(habit: Habit) {
        viewModelScope.launch {
            val updatedHabit= habit.copy(isCompletedToday = !habit.isCompletedToday)
            habitDao.insertHabit(updatedHabit)
        }
    }
}