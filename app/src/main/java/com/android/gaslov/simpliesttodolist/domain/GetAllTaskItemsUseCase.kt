package com.android.gaslov.simpliesttodolist.domain

class GetAllTaskItemsUseCase(private val toDoListRepository: ToDoListRepository) {

    fun getAllTaskItems(): List<TaskItem> {
        return toDoListRepository.getAllTaskItems()
    }
}