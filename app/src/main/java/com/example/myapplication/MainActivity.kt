package com.example.myapplication

import Intent.IntentScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

//            intent()
            IntentScreen()
//            RatingScreen()
//            SimpleDropdown()
//            SpinnerExample()

//            Progress Bars
//            CircularProgressExample()
//            LinearProgressExample()
//            IndeterminateLinearProgress()
//            ProgressWithText()
//            AnimatedProgressBar()
//            CustomColorProgressBar()
//            CircularProgressWithValue()
//            StepProgressBar()
//            GradientProgressBar()
//            LoadingSimulation()



        }
    }
}
