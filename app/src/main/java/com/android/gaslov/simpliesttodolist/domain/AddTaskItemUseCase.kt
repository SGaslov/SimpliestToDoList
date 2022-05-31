package com.android.gaslov.simpliesttodolist.domain

class AddTaskItemUseCase(private val toDoListRepository: ToDoListRepository) {

    suspend fun addTaskItem(taskItem: TaskItem) {
        toDoListRepository.addTaskItem(taskItem)
    }
}