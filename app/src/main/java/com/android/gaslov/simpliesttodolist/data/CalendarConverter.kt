package com.android.gaslov.simpliesttodolist.data

import androidx.room.TypeConverter
import java.util.*

class CalendarConverter {

    @TypeConverter
    fun fromLong(value: Long): GregorianCalendar {
        return GregorianCalendar().apply {
            timeInMillis = value
        }
    }

    @TypeConverter
    fun calendarToLong(calendar: GregorianCalendar): Long {
        return calendar.timeInMillis
    }
}