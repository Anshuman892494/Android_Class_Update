package com.example.myapplication

import Progress_Bars.AnimatedProgressBar
import Progress_Bars.CircularProgressExample
import Progress_Bars.CircularProgressWithValue
import Progress_Bars.CustomColorProgressBar
import Progress_Bars.GradientProgressBar
import Progress_Bars.IndeterminateLinearProgress
import Progress_Bars.LinearProgressExample
import Progress_Bars.LoadingSimulation
import Progress_Bars.ProgressWithText
import Progress_Bars.StepProgressBar
import Scroll_practice.NestedScrollScreen
import Splash_Screen.SplashApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import rating_bar.RatingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


//            Rating Star
              RatingScreen()

//            NestedScrollScreen()
//            SplashApp()

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
