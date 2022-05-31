package com.android.gaslov.simpliesttodolist.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "to_do_list")
data class TaskItemDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val taskText: String,
    val deadLine: GregorianCalendar,
    val reminder: GregorianCalendar
)
