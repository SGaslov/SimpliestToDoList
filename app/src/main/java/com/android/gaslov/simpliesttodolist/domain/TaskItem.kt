package com.android.gaslov.simpliesttodolist.domain

import java.util.*

data class TaskItem(
    var id: Int = UNDEFINED_ID,
    val taskName: String,
    val taskText: String,
    val deadLine: GregorianCalendar,
    val reminder: GregorianCalendar
) {

    companion object {
        const val UNDEFINED_ID = 0
    }
}