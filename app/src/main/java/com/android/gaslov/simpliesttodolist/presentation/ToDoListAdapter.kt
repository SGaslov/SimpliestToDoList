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
import java.time.format.DateTimeFormatter
import java.util.*

class ToDoListAdapter(private val ToDoList: List<TaskItem>) : RecyclerView.Adapter<ToDoListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ToDoListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_item, parent, false)
        return ToDoListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoListViewHolder, position: Int) {
        val taskItem = ToDoList[position]

        val format = SimpleDateFormat("yyyy.MM.dd\nHH:mm", Locale("ru", "RU"))
        val deadLineFormatted = format.format(taskItem.deadLine.time)

        holder.taskTextView.text = taskItem.taskName
        holder.deadLineTextView.text = deadLineFormatted
    }

    override fun getItemCount() = ToDoList.size

    class ToDoListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val taskTextView: TextView
        val deadLineTextView: TextView

        init {
            taskTextView = view.findViewById(R.id.taskTextView)
            deadLineTextView = view.findViewById(R.id.deadLineTextView)
        }
    }
}