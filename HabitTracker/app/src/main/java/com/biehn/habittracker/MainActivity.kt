package com.biehn.habittracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.biehn.habittracker.ui.theme.HabitTrackerTheme
import java.time.LocalDate
import java.time.LocalTime
import androidx.compose.foundation.lazy.items
import androidx.room.Entity
import androidx.room.PrimaryKey

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabitTrackerTheme {
                HabitListScreen()
            }
        }
    }
}

@Composable
fun HabitItemCard(
    habit: Habit,
    onToggle: (Habit) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (habit.isCompletedToday) Color.hsl(
                120f,
                0.5f,
                0.9f
            ) else Color.LightGray
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = habit.title)
                Text(text = habit.description)
                Text(text = "연속 성공: ${habit.successCount}회 | NMT 위험도: ${habit.failCount}")
            }

            Checkbox(
                checked = habit.isCompletedToday,
                onCheckedChange = {
                    onToggle(habit)
                }
            )
        }
    }
}

@Composable
fun HabitListScreen(viewModel: HabitViewModel = viewModel()) {
    val habitList by viewModel.habits.collectAsState()
    LazyColumn {
        items(habitList) { habit ->
            HabitItemCard(
                habit = habit,
                onToggle = { clickedHabit ->
                    viewModel.toggleHabitCompletion(clickedHabit)
                }
            )
        }
    }
}


















