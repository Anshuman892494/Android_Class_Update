package com.example.myapplication

import Dropdown_Spinner_practice.SimpleDropdown
import Dropdown_Spinner_practice.SpinnerExample
import Scroll_practice.VerticalScrollExample
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            StudentDashboard()
//            VerticalScrollExample()
            SimpleDropdown()
//            SpinnerExample()
        }
    }
}
