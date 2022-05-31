package com.android.gaslov.simpliesttodolist.data

import android.app.Application
import com.android.gaslov.simpliesttodolist.domain.TaskItem
import com.android.gaslov.simpliesttodolist.domain.ToDoListRepository

class ToDoListRepositoryImpl(application: Application) : ToDoListRepository {

    private val db = ToDoListDatabase.getInstance(application)
    private val toDoListDao = db.toDoListDao()
    private val toDoListMapper: ToDoListMapper = ToDoListMapper()

    override suspend fun addTaskItem(taskItem: TaskItem) {
        toDoListDao.addTaskItem(toDoListMapper.mapEntityToDbModel(taskItem))
    }

    override fun getAllTaskItems(): List<TaskItem> {
        val taskItemsDbList = toDoListDao.getAllTaskItems()
        return taskItemsDbList.map { toDoListMapper.mapDbModelToEntity(it) }
    }
}