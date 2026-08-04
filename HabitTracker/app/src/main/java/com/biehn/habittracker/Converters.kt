package com.biehn.habittracker

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalTime

class Converters {

    // 1. LocalDate <-> String 변환
    @TypeConverter
    fun fromLocalDate(date: LocalDate?): String? {
        return date?.toString() // 객체를 문자열("2024-05-20")로 변환해서 DB에 저장
    }

    @TypeConverter
    fun toLocalDate(dateString: String?): LocalDate? {
        // 문자열을 받아서 다시 LocalDate 객체로 복원
        return dateString?.let { LocalDate.parse(it) }
    }

    // 2. LocalTime <-> String 변환
    @TypeConverter
    fun fromLocalTime(time: LocalTime?): String? {
        return time?.toString() // 시간 객체를 문자열("07:30")로 변환
    }

    @TypeConverter
    fun toLocalTime(timeString: String?): LocalTime? {
        // 문자열을 다시 시간 객체로 복원
        return timeString?.let { LocalTime.parse(it) }
    }
}