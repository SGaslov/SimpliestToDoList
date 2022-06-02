package com.android.gaslov.simpliesttodolist.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.gaslov.simpliesttodolist.R
import com.android.gaslov.simpliesttodolist.domain.TaskItem
import java.util.*


class ListFragment : Fragment() {

    private lateinit var toDoListAdapter: ToDoListAdapter

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
                0,
                "1 Shawarma's name comes from the Arabic word for \"turning\"",
                "1 Shawarma's name comes from the Arabic word for \"turning\" -- a reference to how this favorite Middle Eastern sandwich's meaty filling cooks on a vertical spit. In adaptations that spread to the Mediterranean and Europe, shawarma has been reinterpreted as gyro in Greece or doner kebab in Germany, via Turkey.",
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 48),
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 58)
            ),
            TaskItem(
                0,
                "1 Shawarma's name comes from the Arabic word for \"turning\"",
                "1 Shawarma's name comes from the Arabic word for \"turning\" -- a reference to how this favorite Middle Eastern sandwich's meaty filling cooks on a vertical spit. In adaptations that spread to the Mediterranean and Europe, shawarma has been reinterpreted as gyro in Greece or doner kebab in Germany, via Turkey.",
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 48),
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 58)
            ),
            TaskItem(
                0,
                "1 Shawarma's name comes from the Arabic word for \"turning\"",
                "1 Shawarma's name comes from the Arabic word for \"turning\" -- a reference to how this favorite Middle Eastern sandwich's meaty filling cooks on a vertical spit. In adaptations that spread to the Mediterranean and Europe, shawarma has been reinterpreted as gyro in Greece or doner kebab in Germany, via Turkey.",
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 48),
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 58)
            ),
            TaskItem(
                0,
                "1 Shawarma's name comes from the Arabic word for \"turning\"",
                "1 Shawarma's name comes from the Arabic word for \"turning\" -- a reference to how this favorite Middle Eastern sandwich's meaty filling cooks on a vertical spit. In adaptations that spread to the Mediterranean and Europe, shawarma has been reinterpreted as gyro in Greece or doner kebab in Germany, via Turkey.",
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 48),
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 58)
            ),
            TaskItem(
                0,
                "1 Shawarma's name comes from the Arabic word for \"turning\"",
                "1 Shawarma's name comes from the Arabic word for \"turning\" -- a reference to how this favorite Middle Eastern sandwich's meaty filling cooks on a vertical spit. In adaptations that spread to the Mediterranean and Europe, shawarma has been reinterpreted as gyro in Greece or doner kebab in Germany, via Turkey.",
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 48),
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 58)
            ),
            TaskItem(
                0,
                "1 Shawarma's name comes from the Arabic word for \"turning\"",
                "1 Shawarma's name comes from the Arabic word for \"turning\" -- a reference to how this favorite Middle Eastern sandwich's meaty filling cooks on a vertical spit. In adaptations that spread to the Mediterranean and Europe, shawarma has been reinterpreted as gyro in Greece or doner kebab in Germany, via Turkey.",
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 48),
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 58)
            ),
            TaskItem(
                0,
                "1 Shawarma's name comes from the Arabic word for \"turning\"",
                "1 Shawarma's name comes from the Arabic word for \"turning\" -- a reference to how this favorite Middle Eastern sandwich's meaty filling cooks on a vertical spit. In adaptations that spread to the Mediterranean and Europe, shawarma has been reinterpreted as gyro in Greece or doner kebab in Germany, via Turkey.",
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 48),
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 58)
            ),
            TaskItem(
                0,
                "1 Shawarma's name comes from the Arabic word for \"turning\"",
                "1 Shawarma's name comes from the Arabic word for \"turning\" -- a reference to how this favorite Middle Eastern sandwich's meaty filling cooks on a vertical spit. In adaptations that spread to the Mediterranean and Europe, shawarma has been reinterpreted as gyro in Greece or doner kebab in Germany, via Turkey.",
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 48),
                GregorianCalendar(2018, Calendar.DECEMBER, 31, 14, 58)
            ),
        )

        toDoListAdapter = ToDoListAdapter(toDoList)

        setUpRecyclerView(view)

        setUpAddTaskClickListener()
    }

    private fun setUpRecyclerView(view: View) {
        val linearLayoutManager = LinearLayoutManager(requireActivity()).apply {
            stackFromEnd = true
        }

        val toDoListRecyclerView =
            view.findViewById<RecyclerView?>(R.id.toDoListRecyclerView).apply {
                layoutManager = linearLayoutManager
                adapter = toDoListAdapter
            }
    }

    private fun setUpAddTaskClickListener() {
        toDoListAdapter.onAddTaskClickListener = {
            requireActivity().supportFragmentManager.beginTransaction()
                .add(
                    R.id.toDoListFragmentContainerView,
                    TaskItemFragment.newInstance("String1", "String2")
                )
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .commit()
        }
    }
}