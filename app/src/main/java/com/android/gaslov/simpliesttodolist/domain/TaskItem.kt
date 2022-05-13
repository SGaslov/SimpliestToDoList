package com.android.gaslov.simpliesttodolist.domain

import java.util.*

data class TaskItem(
    val taskName: String,
    val taskText: String,
    val deadLine: GregorianCalendar,
    val reminder: GregorianCalendar
)