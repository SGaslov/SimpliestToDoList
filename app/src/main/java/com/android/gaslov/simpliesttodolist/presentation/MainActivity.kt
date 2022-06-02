package com.android.gaslov.simpliesttodolist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.gaslov.simpliesttodolist.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.toDoListFragmentContainerView, ListFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}