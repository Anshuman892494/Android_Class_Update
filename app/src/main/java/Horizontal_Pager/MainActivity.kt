package Horizontal_Pager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                TabWithPager()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabWithPager() {

    val tabs = listOf(
        "Home" to Icons.Default.Home,
        "Chats" to Icons.Default.Chat,
        "Status" to Icons.Default.Notifications,
        "Community" to Icons.Default.Groups,
        "Gallery" to Icons.Default.Image,
        "Profile" to Icons.Default.Person,
        "Settings" to Icons.Default.Settings
    )

    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { tabs.size }
    )

    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding()
    ) {

        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            edgePadding = 0.dp
        ) {
            tabs.forEachIndexed { index, (title, icon) ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = { Text(text = title) },
                    icon = { Icon(imageVector = icon, contentDescription = title) }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->

            when (page) {
                0 -> ScreenContent("Home Screen")
                1 -> ScreenContent("Chat Screen")
                2 -> ScreenContent("Status Screen")
                3 -> ScreenContent("Community Screen")
                4 -> ScreenContent("Gallery Screen")
                5 -> ScreenContent("Profile Screen")
                6 -> ScreenContent("Settings Screen")
            }
        }
    }
}

@Composable
fun ScreenContent(text: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}