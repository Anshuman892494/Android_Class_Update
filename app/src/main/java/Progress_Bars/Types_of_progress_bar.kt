package Progress_Bars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

    @Composable
    fun CircularProgressExample() {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(60.dp),
                strokeWidth = 10.dp
            )
        }
    }

    @Composable
    fun LinearProgressExample() {

        var progress by remember { mutableStateOf(0.0f) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {

            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                progress += 1.0f
                if (progress > 1f) progress = 0f
            }) {
                Text("Increase Progress")
            }
        }
    }

    @Composable
    fun IndeterminateLinearProgress() {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .statusBarsPadding()
        )
    }

    @Composable
    fun ProgressWithText() {
        var progress by remember { mutableStateOf(0.7f) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "${(progress * 100).toInt()}%")
        }
    }

    @Composable
    fun AnimatedProgressBar() {

        var progress by remember { mutableStateOf(0f) }

        val animatedProgress by animateFloatAsState(
            targetValue = progress,
            animationSpec = tween(durationMillis = 1000)
        )

        Column(
            modifier = Modifier.padding(20.dp).statusBarsPadding()
        ) {

            LinearProgressIndicator(
                progress = animatedProgress,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                progress = (0..100).random() / 100f
            }) {
                Text("Random Progress")
            }
        }
    }

    @Composable
    fun CustomColorProgressBar() {
        LinearProgressIndicator(
            progress = 0.7f,
            color = Color.Green,
            trackColor = Color.LightGray,
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
                .padding(16.dp)
                .statusBarsPadding()
        )
    }
    @Composable
    fun CircularProgressWithValue() {

        val progress = 0.75f

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(120.dp)
        ) {
            CircularProgressIndicator(
                progress = progress,
                strokeWidth = 8.dp
            )

            Text(text = "${(progress * 100).toInt()}%")
        }
    }

    @Composable
    fun StepProgressBar() {

        val steps = 5
        val currentStep = 3

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(0.8f), // control width
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (i in 1..steps) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                if (i <= currentStep) Color.Blue else Color.Gray,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "$i",
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
    @Composable
    fun GradientProgressBar() {

        val brush = Brush.horizontalGradient(
            colors = listOf(Color.Red, Color.Yellow, Color.Green)
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f) // control width
                    .height(12.dp)
                    .background(Color.LightGray, shape = RoundedCornerShape(50))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.6f) // progress value
                        .fillMaxHeight()
                        .background(brush, shape = RoundedCornerShape(50))
                )
            }
        }
    }
    @Composable
    fun LoadingSimulation() {

        var isLoading by remember { mutableStateOf(true) }

        LaunchedEffect(Unit) {
            delay(3000)
            isLoading = false
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (isLoading) {
                CircularProgressIndicator()
            } else {
                Text("Data Loaded Successfully!")
            }
        }
    }

    @Preview
    @Composable
    fun Text()
    {
//        CircularProgressExample()
//        LinearProgressExample()
//        IndeterminateLinearProgress()
//        ProgressWithText()
//        AnimatedProgressBar()
//        CustomColorProgressBar()
    }
