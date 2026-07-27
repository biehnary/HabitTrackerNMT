package com.biehn.habittracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.biehn.habittracker.ui.theme.HabitTrackerTheme
import java.time.LocalDate
import java.time.LocalTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {






        }
    }
}


data class Habit(
    val id: Long,
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
    var alarmTime: LocalTime,
    var isPaused: Boolean = false
    )

@Composable
fun HabitItemCard(habit: Habit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = habit.title)
            Text(text = habit.description)
            Text(text = "우선순위: ${habit.priority} | )
        }
    }
}




















