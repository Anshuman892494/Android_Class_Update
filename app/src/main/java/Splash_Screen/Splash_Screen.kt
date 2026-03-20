package Splash_Screen

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun SplashApp() {

    var showSplash by remember { mutableStateOf(true) }

    if (showSplash) {
        SplashScreen {
            showSplash = false
        }
    } else {
        HomeScreen()
    }
}

@Composable
fun SplashScreen(onTimeout: () -> Unit) {

    LaunchedEffect(Unit) {
        delay(3000) // 3 seconds splash delay
        onTimeout()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = "Welcome to My App",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Home Screen",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}