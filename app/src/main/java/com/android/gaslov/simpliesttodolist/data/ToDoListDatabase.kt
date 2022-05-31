package com.android.gaslov.simpliesttodolist.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [TaskItemDbModel::class], version = 1, exportSchema = false)
@TypeConverters(CalendarConverter::class)
abstract class ToDoListDatabase : RoomDatabase() {

    abstract fun toDoListDao(): ToDoListDao

    companion object {

        private var INSTANCE: ToDoListDatabase? = null
        private const val DB_NAME = "to_do_list_db"
        private val LOCK = Any()

        fun getInstance(application: Application): ToDoListDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    ToDoListDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = db
                return db
            }
        }
    }
}