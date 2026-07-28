package com.biehn.habittracker

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import java.time.LocalTime

class HabitViewModel : ViewModel() {

    private val _habits = MutableStateFlow<List<Habit>> (emptyList())
    val habits: StateFlow<List<Habit>> = _habits.asStateFlow()

    init {
        _habits.value = listOf(
            Habit(id = 1, title = "아침 찬물 샤워", description = "NMT 방어용", priority = 1, displayOrder = 1, repetitionDays = 1, alarmTime = LocalTime.of(7,0), startDate = LocalDate.now(), endDate = null, isCompletedToday = false),
            Habit(id = 2, title = "알고리즘 1문제", description = "코딩 테스트 대비", priority = 2, displayOrder = 2, repetitionDays = 1, alarmTime = LocalTime.of(9,0), startDate = LocalDate.now(), endDate = null, isCompletedToday = false)
        )
    }

    // 비즈니스 로직: 체크박스 토글
    fun toggleHabitCompletion(habitId: Long) {
        _habits.update {currentList ->
            currentList.map { habit ->
                if (habit.id == habitId) {
                    habit.copy(isCompletedToday = !habit.isCompletedToday)
                } else {
                    habit
                }
            }
        }
    }
}