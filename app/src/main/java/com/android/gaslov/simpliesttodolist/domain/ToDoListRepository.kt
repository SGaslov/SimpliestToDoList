package com.android.gaslov.simpliesttodolist.domain

interface ToDoListRepository {

    suspend fun addTaskItem(taskItem: TaskItem)

    fun getAllTaskItems(): List<TaskItem>
}