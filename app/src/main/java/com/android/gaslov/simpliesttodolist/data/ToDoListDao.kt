package com.android.gaslov.simpliesttodolist.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ToDoListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTaskItem(taskItemDbModel: TaskItemDbModel)

    @Query("SELECT * FROM to_do_list")
    fun getAllTaskItems(): List<TaskItemDbModel>
}