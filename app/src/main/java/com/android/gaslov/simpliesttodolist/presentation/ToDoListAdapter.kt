package com.android.gaslov.simpliesttodolist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.gaslov.simpliesttodolist.R
import com.android.gaslov.simpliesttodolist.domain.TaskItem
import com.android.gaslov.simpliesttodolist.presentation.ToDoListAdapter.ToDoListViewHolder
import java.text.SimpleDateFormat
import java.util.*

class ToDoListAdapter(private val ToDoList: List<TaskItem>) :
    RecyclerView.Adapter<ToDoListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ToDoListViewHolder {
        return when (viewType) {
            TASK_ITEM -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.task_item, parent, false)
                TaskItemViewHolder(view)
            }
            ADD_TASK_ITEM_BUTTON -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.add_task_item_button, parent, false)
                AddItemButtonViewHolder(view)
            }
            else -> throw RuntimeException("Unknown item view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: ToDoListViewHolder, position: Int) {
        val viewType = getItemViewType(position)

        when (viewType) {
            TASK_ITEM -> {
                val taskItem = ToDoList[position]

                (holder as TaskItemViewHolder).apply {
                    taskTextView.text = getTaskName(taskItem)
                    deadLineTextView.text = getDeadLineFormattedDate(taskItem)
                }
            }
        }
    }

    private fun getDeadLineFormattedDate(taskItem: TaskItem): String {
        val format = SimpleDateFormat("yyyy.MM.dd\nHH:mm", Locale("ru", "RU"))
        return format.format(taskItem.deadLine.time)
    }

    private fun getTaskName(taskItem: TaskItem): String {
        val taskNameMaxSymbolsNumber = 90
        return if (taskItem.taskText.length <= taskNameMaxSymbolsNumber) {
            taskItem.taskText
        } else {
            taskItem.taskText.take(taskNameMaxSymbolsNumber) + "..."
        }
    }

    override fun getItemCount() = ToDoList.size + 1

    override fun getItemViewType(position: Int): Int {
        return if (position == (itemCount - 1)) ADD_TASK_ITEM_BUTTON else TASK_ITEM
    }

    open class ToDoListViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class TaskItemViewHolder(view: View) : ToDoListViewHolder(view) {

        val taskTextView: TextView
        val deadLineTextView: TextView

        init {
            taskTextView = view.findViewById(R.id.taskTextView)
            deadLineTextView = view.findViewById(R.id.deadLineTextView)
        }
    }

    class AddItemButtonViewHolder(view: View) : ToDoListViewHolder(view)

    companion object {
        const val TASK_ITEM: Int = 0
        const val ADD_TASK_ITEM_BUTTON: Int = 1
    }
}