package com.android.gaslov.simpliesttodolist.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.gaslov.simpliesttodolist.R
import com.android.gaslov.simpliesttodolist.domain.TaskItem
import java.util.*


class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toDoList: List<TaskItem> = listOf(
            TaskItem(
                "1 Shawarma's name comes from the Arabic word for \"turning\" -- a reference to how this favorite Middle Eastern sandwich's meaty filling cooks on a vertical spit. In adaptations that spread to the Mediterranean and Europe, shawarma has been reinterpreted as gyro in Greece or doner kebab in Germany, via Turkey.",
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 48),
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 58)
            ),
            TaskItem(
                "2 Shawarma's name comes from the Arabic word for \"turning\" -- a reference to how this favorite Middle Eastern sandwich's meaty filling cooks on a vertical spit. In adaptations that spread to the Mediterranean and Europe, shawarma has been reinterpreted as gyro in Greece or doner kebab in Germany, via Turkey.",
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 48),
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 58)
            ),
            TaskItem(
                "3 Shawarma's name comes from the Arabic word for \"turning\" -- a reference to how this favorite Middle Eastern sandwich's meaty filling cooks on a vertical spit. In adaptations that spread to the Mediterranean and Europe, shawarma has been reinterpreted as gyro in Greece or doner kebab in Germany, via Turkey.",
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 48),
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 58)
            ),
            TaskItem(
                "4 Shawarma's name comes from the Arabic word for \"turning\" -- a reference to how this favorite Middle Eastern sandwich's meaty filling cooks on a vertical spit. In adaptations that spread to the Mediterranean and Europe, shawarma has been reinterpreted as gyro in Greece or doner kebab in Germany, via Turkey.",
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 48),
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 58)
            ),
            TaskItem(
                "5 Shawarma's name comes from the Arabic word for \"turning\" -- a reference to how this favorite Middle Eastern sandwich's meaty filling cooks on a vertical spit. In adaptations that spread to the Mediterranean and Europe, shawarma has been reinterpreted as gyro in Greece or doner kebab in Germany, via Turkey.",
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 48),
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 58)
            ),
            TaskItem(
                "6 Shawarma's name comes from the Arabic word for \"turning\" -- a reference to how this favorite Middle Eastern sandwich's meaty filling cooks on a vertical spit. In adaptations that spread to the Mediterranean and Europe, shawarma has been reinterpreted as gyro in Greece or doner kebab in Germany, via Turkey.",
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 48),
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 58)
            ),
            TaskItem(
                "7 Shawarma's name comes from the Arabic word for \"turning\" -- a reference to how this favorite Middle Eastern sandwich's meaty filling cooks on a vertical spit. In adaptations that spread to the Mediterranean and Europe, shawarma has been reinterpreted as gyro in Greece or doner kebab in Germany, via Turkey.",
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 48),
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 58)
            ),
            TaskItem(
                "8 Shawarma's name comes from the Arabic word for \"turning\" -- a reference to how this favorite Middle Eastern sandwich's meaty filling cooks on a vertical spit. In adaptations that spread to the Mediterranean and Europe, shawarma has been reinterpreted as gyro in Greece or doner kebab in Germany, via Turkey.",
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 48),
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 58)
            )
        )

        val toDoListAdapter = ToDoListAdapter(toDoList)
        val linearLayoutManager = LinearLayoutManager(requireActivity()).apply {
            stackFromEnd = true
        }

        val toDoListRecyclerView =
            view.findViewById<RecyclerView?>(R.id.toDoListRecyclerView).apply {
                layoutManager = linearLayoutManager
                adapter = toDoListAdapter
            }
    }
}