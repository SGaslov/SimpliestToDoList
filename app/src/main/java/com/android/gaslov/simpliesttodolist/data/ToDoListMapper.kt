package com.android.gaslov.simpliesttodolist.data

import com.android.gaslov.simpliesttodolist.domain.TaskItem

class ToDoListMapper {

    fun mapEntityToDbModel(taskItem: TaskItem): TaskItemDbModel {
        return TaskItemDbModel(
            id = taskItem.id,
            taskText = taskItem.taskText,
            deadLine = taskItem.deadLine,
            reminder = taskItem.reminder
        )
    }

    fun mapDbModelToEntity(taskItemDbModel: TaskItemDbModel): TaskItem {
        val taskName = if (taskItemDbModel.taskText.length <= TASK_NAME_MAX_SYMBOLS_NUMBER) {
            taskItemDbModel.taskText
        } else {
            taskItemDbModel.taskText.take(TASK_NAME_MAX_SYMBOLS_NUMBER) + "..."
        }
        return TaskItem(
            id = taskItemDbModel.id,
            taskName = taskName,
            taskText = taskItemDbModel.taskText,
            deadLine = taskItemDbModel.deadLine,
            reminder = taskItemDbModel.reminder
        )
    }

    companion object {

        const val TASK_NAME_MAX_SYMBOLS_NUMBER = 90
    }
}